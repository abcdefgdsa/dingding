package com.example.myapp.controller;

import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.service.UserInfo;
import com.example.myapp.service.UserService;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关信息
 */
@Slf4j
@TokenRequired
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/getUser")
    public UserInfo getUser( ) throws Exception {

        return userService.getUserInfo("e5a9b21980af31beb1bb77c9e9f69b20");
    }
}
