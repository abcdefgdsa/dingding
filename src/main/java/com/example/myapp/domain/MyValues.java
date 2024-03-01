package com.example.myapp.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 将Myvalues放进threadlocal，threadlocal就能存两个值
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyValues {

    /**
     * 员工id
     */
    private String userId;

    /**
     * 员工姓名
     */
    private String userName;

    /**
     * 部门id
     */
    private String unionId;


}
