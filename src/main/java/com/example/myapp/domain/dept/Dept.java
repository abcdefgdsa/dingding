package com.example.myapp.domain.dept;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Dept {

    /**
     * 部门主键id
     */
    @TableId(type = IdType.INPUT)
    private Integer id;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 父部门id
     */
    private  Integer parentId;

}
