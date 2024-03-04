package com.example.myapp.controller.process;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.MyValues;
import com.example.myapp.domain.process.Process;
import com.example.myapp.domain.project.approval.caiwu.Caiwu;
import com.example.myapp.exception.ApprovalException;
import com.example.myapp.service.ActivitiService;
import com.example.myapp.service.MsgService;
import com.example.myapp.service.process.ProcessService;
import com.example.myapp.service.project.approval.caiwu.CaiwuService;
import com.example.myapp.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    public ProcessService processService;


    /**
     * 根据项目id查询审批节点的状态
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        List<Process> processes = processService.selectByBaseId(baseId);
        return AjaxResult.success(processes);
    }


}
