package com.example.myapp.controller;

import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.service.MsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    public MsgService msgService;

    @GetMapping("/test")
    public AjaxResult sendMsg() throws Exception {
        msgService.sendMsg("0223043233301062376","收到一条新的项目立项消息需要您审批!");
        return AjaxResult.success();
    }
}
