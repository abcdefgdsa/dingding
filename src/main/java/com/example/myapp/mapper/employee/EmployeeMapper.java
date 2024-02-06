package com.example.myapp.mapper.employee;

import com.example.myapp.domain.employee.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.example.myapp.domain.user.User
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}




