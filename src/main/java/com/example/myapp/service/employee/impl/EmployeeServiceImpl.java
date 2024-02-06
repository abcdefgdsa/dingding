package com.example.myapp.service.employee.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.employee.Employee;
import com.example.myapp.mapper.employee.EmployeeMapper;
import com.example.myapp.service.employee.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService {

    @Override
    public List<Employee> selectEmployeeByDeptId(Integer deptId) {
        LambdaQueryWrapper<Employee> wrapper=new LambdaQueryWrapper<>();

        wrapper.eq(Employee::getDeptId,deptId);
        return list(wrapper);
    }

    @Override
    public Boolean saveEmployees(List<Employee> list) {
        boolean flag = saveBatch(list);
        return flag;
    }
}




