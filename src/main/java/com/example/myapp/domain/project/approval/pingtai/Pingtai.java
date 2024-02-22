package com.example.myapp.domain.project.approval.pingtai;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 平台部审批
 * @TableName pingtai
 */
@TableName(value ="pingtai")
@Data
public class Pingtai implements Serializable {
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
     * 是否有技术风险 0否 1是
     */
    private String isRisk;

    /**
     * 平台产品版本
     */
    private String version;

    /**
     * 部分是否可由交付开发 0否1是
     */
    private String isShare;

    /**
     * 预计开发周期  单位为月
     */
    private Integer month;

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