package com.example.myapp.domain.project.approval.fangan;

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
 * 方案部审批
 * @TableName fangan
 */
@TableName(value ="fangan")
@Data
public class Fangan implements Serializable {
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
     * 产品/赛道重合度
     */
    private String repeatDegree;

    /**
     * 产品技术应用可行性
     */
    private String feasibility;

    /**
     * 见客户交流情况
     */
    private String communication;

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