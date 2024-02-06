package com.example.myapp.controller;

import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.employee.Employee;
import com.example.myapp.service.DeptAndUserService;
import com.example.myapp.service.employee.EmployeeService;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public DeptAndUserService deptAndUserService;

    /**
     * 保存所有人员信息
     * @return
     * @throws ApiException
     */
    @GetMapping("/saveEmployees")
    public String getUser( )throws ApiException {

        deptAndUserService.departmentUserInfo();
        return "";
//        return employeeService.saveEmployees(deptAndUserService.departmentUserInfo());
    }
}
