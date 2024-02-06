package com.example.myapp.domain.employee;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Employee {

    @TableId(type = IdType.INPUT)
    private String id;

    private String userName;

    private String position;

    private String phone;

    private Integer deptId;
}
