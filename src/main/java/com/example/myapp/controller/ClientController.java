package com.example.myapp.controller;

import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping("/getClientData")
    public String getClient( ) throws Exception {
         return clientService.queryAllClients();
    }

}
