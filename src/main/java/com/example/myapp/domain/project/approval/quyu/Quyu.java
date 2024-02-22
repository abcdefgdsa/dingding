package com.example.myapp.domain.project.approval.quyu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 区域部审批
 * @TableName quyu
 */
@TableName(value ="quyu")
@Data
public class Quyu implements Serializable {
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
     * 项目资金是否到位  0否 1是
     */
    private String isArrive;

    /**
     * 项目最低利润空间评判
     */
    private String evaluation;

    /**
     * 是否有预付款 0否1是
     */
    private String isPay;

    /**
     * 回款时间约定
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate payTime;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime approvalTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}