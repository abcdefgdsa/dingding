package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.MyValues;
import com.example.myapp.domain.process.Process;
import com.example.myapp.domain.project.approval.chanping.Chanping;
import com.example.myapp.exception.ApprovalException;
import com.example.myapp.service.ActivitiService;
import com.example.myapp.service.MsgService;
import com.example.myapp.service.process.ProcessService;
import com.example.myapp.service.project.approval.chanping.ChanpingService;
import com.example.myapp.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/chanping")
public class ChanpingController {

    @Autowired
    public ChanpingService chanpingService;

    @Autowired
    public ActivitiService activitiService;

    @Autowired
    public ProcessService processService;

    @Autowired
    public MsgService msgService;

    /**
     * 查询产品部评审信息
     *
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId) {
        Chanping chanping = chanpingService.selectApproval(baseId);
        return AjaxResult.success(chanping);
    }

    /**
     * 新增产品部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Chanping chanping) throws Exception {

        BaseContext.setCurrentUserAndUnion("12345", "chanping", "661262569");
        //从threadLocal中拿到userId和UnionId
        MyValues myValues = BaseContext.getCurrentUserAndUnion();

        //如果目前该部门没有任务（目前只考虑单个任务），则抛出异常
        if (!activitiService.isTimeApproval(myValues.getUnionId(),chanping.getBaseId()))
            throw new ApprovalException("没到时间审批");

        //审批
        boolean flag = chanpingService.addApproval(chanping);

        //审批完之后，流程图上对应改变
        Process process = new Process();
        process.setBaseId(chanping.getBaseId());
        process.setDeptId("661262569");
        process.setApprovalBy(myValues.getUserId());
        process.setApprovalStatus(chanping.getApprovalStatus());
        process.setApprovalTime(LocalDateTime.now());
        processService.updateApproval(process);

        //若审批结果为同意，则流程进行到下一步
        if ("1".equals(chanping.getApprovalStatus())) {
            activitiService.completTask(myValues.getUnionId(),chanping.getBaseId());
            //若审批同意，则发消息给产品部审批
            msgService.sendMsg("0223043233301062376", "方案部，您有一条项目审批的消息");
        }

        if (flag)
            return AjaxResult.success("产品部评审添加成功");
        return AjaxResult.error("产品部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Chanping chanping) throws Exception {

        BaseContext.setCurrentUserAndUnion("12345", "chanping", "661262569");

        //从threadLocal中拿到userId和UnionId
        MyValues myValues = BaseContext.getCurrentUserAndUnion();

        boolean flag = chanpingService.updateApproval(chanping);

        //审批完之后，流程图上对应改变
        Process process = new Process();
        process.setBaseId(chanping.getBaseId());
        process.setDeptId("661262569");
        process.setApprovalBy(myValues.getUserId());
        process.setApprovalStatus(chanping.getApprovalStatus());
        process.setApprovalTime(LocalDateTime.now());
        processService.updateApproval(process);

        //若审批结果为同意，则流程进行到下一步
        if ("1".equals(chanping.getApprovalStatus())) {
            activitiService.completTask(myValues.getUnionId(),chanping.getBaseId());
            //若审批同意，则发消息给产品部审批
            msgService.sendMsg("0223043233301062376", "方案部，您有一条项目审批的消息");
        }

        if (flag)
            return AjaxResult.success("产品部更新评审信息成功");
        return AjaxResult.error("产品部更新评审信息失败");
    }
}
