package com.example.myapp.controller;

import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.dept.Dept;
import com.example.myapp.domain.employee.Employee;
import com.example.myapp.service.DeptAndUserService;
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
@RequestMapping("/dept")
public class DeptAndUserController {

    @Autowired
    public DeptAndUserService deptAndUserService;

    /**
     * 拿到所有部门信息
     * @return
     * @throws ApiException
     */
    @GetMapping("/getDept")
    public List<Dept> getDept( )throws ApiException {
         return deptAndUserService.departmentInfo();
    }

    /**
     * 拿到所有人员信息
     * @return
     * @throws ApiException
     */
    @GetMapping("/getUser")
    public List<Employee> getUser( )throws ApiException {

        return deptAndUserService.departmentUserInfo();
    }


}
