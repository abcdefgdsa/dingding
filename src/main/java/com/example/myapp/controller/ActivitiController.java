package com.example.myapp.controller;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.MyValues;
import com.example.myapp.domain.project.approval.caiwu.Caiwu;
import com.example.myapp.exception.ApprovalException;
import com.example.myapp.service.ActivitiService;
import com.example.myapp.service.project.approval.caiwu.CaiwuService;
import com.example.myapp.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/activiti")
public class ActivitiController {



    @Autowired
    public ActivitiService activitiService;

    /**
     * 根据assingee完成任务
     * @return
     */
    @GetMapping("/approve")
    public void select(@RequestParam String assingee){
        activitiService.completTask(assingee);
    }

    /**
     * 查询当前任务走到哪了
     */
    @GetMapping("/select")
    public void select() {
        activitiService.queryTask();
    }

}
