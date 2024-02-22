package com.example.myapp.domain.project.approval.jiaofu;

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
 * 交付部审批
 * @TableName jiaofu
 */
@TableName(value ="jiaofu")
@Data
public class Jiaofu implements Serializable {
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
     * 交付服务范围
     */
    private String scope;

    /**
     * 交付形式 0轻量化交付 1整体交付
     */
    private String type;

    /**
     * 付款节点和验收流程是否明确 0不明确 1明确
     */
    private String isExplicit;

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