package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.MyValues;
import com.example.myapp.domain.process.Process;
import com.example.myapp.domain.project.approval.shengtai.Shengtai;
import com.example.myapp.exception.ApprovalException;
import com.example.myapp.service.ActivitiService;
import com.example.myapp.service.MsgService;
import com.example.myapp.service.process.ProcessService;
import com.example.myapp.service.project.approval.shengtai.ShengtaiService;
import com.example.myapp.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/shengtai")
public class ShengtaiController {

    @Autowired
    public ShengtaiService shengtaiService;

    @Autowired
    public ActivitiService activitiService;

    @Autowired
    public ProcessService processService;

    @Autowired
    public MsgService msgService;

    /**
     * 查询生态部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Shengtai shengtai =shengtaiService.selectApproval(baseId);
        return AjaxResult.success(shengtai);
    }

    /**
     * 新增生态部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Shengtai shengtai) throws Exception {

        BaseContext.setCurrentUserAndUnion("12345","shengtai","905992062");
        //从threadLocal中拿到userId和UnionId
        MyValues myValues = BaseContext.getCurrentUserAndUnion();
        //如果目前该部门没有任务（目前只考虑单个任务），则抛出异常
        if(!activitiService.isTimeApproval(myValues.getUnionId()))
            throw new ApprovalException("没到时间审批");

        //审批
        boolean flag = shengtaiService.addApproval(shengtai);

        //审批完之后，流程图上对应改变
        Process process = new Process();
        process.setBaseId(shengtai.getBaseId());
        process.setDeptId("905992062");
        process.setApprovalBy(myValues.getUserId());
        process.setApprovalStatus(shengtai.getApprovalStatus());
        process.setApprovalTime(LocalDateTime.now());
        processService.updateApproval(process);

        //若审批结果为同意，则流程进行到下一步
        if("1".equals(shengtai.getApprovalStatus())) {
            activitiService.completTask(myValues.getUnionId());
            //若审批同意，则发消息给产品部审批
            msgService.sendMsg("0223043233301062376", "财务部，您有一条项目审批的消息");
        }
        if(flag)
            return AjaxResult.success("生态部评审添加成功");
        return AjaxResult.error("生态部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Shengtai shengtai) throws Exception {

        BaseContext.setCurrentUserAndUnion("12345","admin","905992062");

        //从threadLocal中拿到userId和UnionId
        MyValues myValues = BaseContext.getCurrentUserAndUnion();

        boolean flag = shengtaiService.updateApproval(shengtai);

        //审批完之后，流程图上对应改变
        Process process = new Process();
        process.setBaseId(shengtai.getBaseId());
        process.setDeptId("905992062");
        process.setApprovalBy(myValues.getUserId());
        process.setApprovalStatus(shengtai.getApprovalStatus());
        process.setApprovalTime(LocalDateTime.now());
        processService.updateApproval(process);

        //若审批结果为同意，则流程进行到下一步
        if("1".equals(shengtai.getApprovalStatus())) {
            activitiService.completTask(myValues.getUnionId());
            //若审批同意，则发消息给产品部审批
            msgService.sendMsg("0223043233301062376", "财务部，您有一条项目审批的消息");
        }
        if(flag)
            return AjaxResult.success("生态部更新评审信息成功");
        return AjaxResult.error("生态部更新评审信息失败");
    }
}
