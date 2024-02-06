package com.example.myapp.service.employee;

import com.example.myapp.domain.employee.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *员工业务层
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 根据部门id查找员工信息
     * @param deptId
     * @return
     */
    public List<Employee> selectEmployeeByDeptId(Integer deptId);


    /**
     * 保存员工信息的list集合
     */
    Boolean saveEmployees(List<Employee> list);

}
