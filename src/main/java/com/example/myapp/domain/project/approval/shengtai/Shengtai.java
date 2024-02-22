package com.example.myapp.domain.project.approval.shengtai;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 生态部审批
 * @TableName shengtai
 */
@TableName(value ="shengtai")
@Data
public class Shengtai implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目基础信息表id
     */
    private Integer baseId;

    /**
     * 项目金额
     */
    private BigDecimal price;

    /**
     * 项目涉及的产品及解决方案

     */
    private String solution;

    /**
     * 项目背景
     */
    private String background;

    /**
     * 客情关系
     */
    private String relation;

    /**
     * 竞争态势
     */
    private String situation;

    /**
     * 风险点
     */
    private String risk;

    /**
     * 是否通过 0不通过 1通过
     */
    private String approvalStatus;

    /**
     * 操作人
     */
    private String approvalBy;

    /**
     * 操作时间
     */
    private Date approvalTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}