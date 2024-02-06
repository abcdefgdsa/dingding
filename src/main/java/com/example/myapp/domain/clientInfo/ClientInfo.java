package com.example.myapp.domain.clientInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfo {

    /**
     * 主键id
     */
    @TableId(type = IdType.INPUT)
    private String id;

    /**
     * 客户名称
     */
    private String clientName;

    /**
     * 客户来源
     */
    private String clientSource;

    /**
     * 客户地址
     */
    private String addr;

    /**
     * 客户地址详细
     */
    private String addrMax;

    /**
     * 联系人名字
     */
    private String personName;

    /**
     * 联系人电话
     */
    private String personPhone;

    /**
     * 联系人职位
     */
    private String position;

    /**
     * 联系人部门
     */
    private String dept;

    /**
     * 类别
     */
    private String type;

    /**
     * 行业
     */
    private String profess;

    /**
     * 是否合作
     */
    private String isTeamwork;

    /**
     * 市场对接人id
     */
    private String teamer;

    /**
     * 创建人id
     */
    private String createBy;


}
