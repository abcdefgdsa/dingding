package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.MyValues;
import com.example.myapp.domain.process.Process;
import com.example.myapp.domain.project.approval.quyu.Quyu;
import com.example.myapp.exception.ApprovalException;
import com.example.myapp.service.ActivitiService;
import com.example.myapp.service.MsgService;
import com.example.myapp.service.process.ProcessService;
import com.example.myapp.service.project.approval.quyu.QuyuService;
import com.example.myapp.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/quyu")
public class QuyuController {

    @Autowired
    public QuyuService quyuService;

    @Autowired
    public ActivitiService activitiService;

    @Autowired
    public ProcessService processService;

    @Autowired
    public MsgService msgService;


    /**
     * 查询区域部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Quyu quyu =quyuService.selectApproval(baseId);
        return AjaxResult.success(quyu);
    }

    /**
     * 新增区域部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Quyu quyu) throws Exception {

        BaseContext.setCurrentUserAndUnion("12345","quyu","662228237");
        //从threadLocal中拿到userId和UnionId
        MyValues myValues = BaseContext.getCurrentUserAndUnion();

        //如果目前该部门没有任务（目前只考虑单个任务），则抛出异常
        if(!activitiService.isTimeApproval(myValues.getUnionId(),quyu.getBaseId()))
            throw new ApprovalException("没到时间审批");

        //审批
        boolean flag = quyuService.addApproval(quyu);

        //审批完之后，流程图上对应改变
        Process process = new Process();
        process.setBaseId(quyu.getBaseId());
        process.setDeptId("662228237");
        process.setApprovalBy(myValues.getUserId());
        process.setApprovalStatus(quyu.getApprovalStatus());
        process.setApprovalTime(LocalDateTime.now());
        processService.updateApproval(process);

        //若审批结果为同意，则流程进行到下一步
        if("1".equals(quyu.getApprovalStatus())) {
            activitiService.completTask(myValues.getUnionId(),quyu.getBaseId());
            //若审批同意，则发消息给产品部审批
            msgService.sendMsg("0223043233301062376", "生态部，您有一条项目审批的消息");
        }

        if(flag)
            return AjaxResult.success("区域部评审添加成功");
        return AjaxResult.error("区域部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Quyu quyu) throws Exception {

        BaseContext.setCurrentUserAndUnion("12345","admin","662228237");

        //从threadLocal中拿到userId和UnionId
        MyValues myValues = BaseContext.getCurrentUserAndUnion();

        boolean flag = quyuService.updateApproval(quyu);

        //审批完之后，流程图上对应改变
        Process process = new Process();
        process.setBaseId(quyu.getBaseId());
        process.setDeptId("662228237");
        process.setApprovalBy(myValues.getUserId());
        process.setApprovalStatus(quyu.getApprovalStatus());
        process.setApprovalTime(LocalDateTime.now());
        processService.updateApproval(process);

        //若审批结果为同意，则流程进行到下一步
        if("1".equals(quyu.getApprovalStatus())) {
            activitiService.completTask(myValues.getUnionId(),quyu.getBaseId());
            //若审批同意，则发消息给产品部审批
            msgService.sendMsg("0223043233301062376", "生态部，您有一条项目审批的消息");
        }
        if(flag)
            return AjaxResult.success("区域部更新评审信息成功");
        return AjaxResult.error("区域部更新评审信息失败");
    }
}
