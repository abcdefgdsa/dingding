package com.example.myapp.controller;

import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.clientInfo.ClientInfo;
import com.example.myapp.service.ClientService;
import com.example.myapp.service.clientInfo.ClientInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/client")
public class ClientController {

    /**
     * 操纵钉钉的service
     */
    @Autowired
    public ClientService clientService;

    /**
     * 操纵数据库的service
     */
    @Autowired
    public ClientInfoService clientInfoService;


    @GetMapping("/getClientData")
    public String getClient( ) throws Exception {
         return clientService.queryAllClients();
    }

    @GetMapping("/getClient")
    public AjaxResult getClient(@RequestParam(required = false) String name){
        List<ClientInfo> list = clientInfoService.selectByName(name);
        return AjaxResult.success(list);
    }

}
