package com.example.myapp.controller.project;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.ProjectApproval;
import com.example.myapp.service.ActivitiService;
import com.example.myapp.service.project.ProjectApprovalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/approval")
public class ProjectApprovalController {

    @Autowired
    public ProjectApprovalService projectApprovalService;

    @Autowired
    public ActivitiService activitiService;

    /**
     * 查询评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        ProjectApproval projectApproval = projectApprovalService.selectApproval(baseId);
        return AjaxResult.success(projectApproval);
    }

    /**
     * 新增评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody ProjectApproval projectApproval) throws Exception {
        boolean flag = projectApprovalService.addApproval(projectApproval);

        //评审后开启审批流程，并把项目基本表id存入流程数据库中
        activitiService.ProcessBoot(projectApproval.getBaseId());

        if(flag)
            return AjaxResult.success("评审添加成功");
        return AjaxResult.error("评审添加失败");
    }

    /**
     * 根据评审id删除评审
     */
    @DeleteMapping("/delete/{approvalId}")
    public AjaxResult deleteById(@PathVariable Integer approvalId) {
        boolean flag = projectApprovalService.deleteApproval(approvalId);
        if(flag)
            return AjaxResult.success("评审删除成功");
        return AjaxResult.error("该评审已被删除");
    }

    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody ProjectApproval projectApproval) {
        boolean flag = projectApprovalService.updateApproval(projectApproval);
        if(flag)
            return AjaxResult.success("更新评审信息成功");
        return AjaxResult.error("更新评审信息失败");
    }
}
