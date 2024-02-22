package com.example.myapp.domain.project.approval.caiwu;

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
 * 财务部审批
 * @TableName caiwu
 */
@TableName(value ="caiwu")
@Data
public class Caiwu implements Serializable {
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
     * 项目资金来源
     */
    private String source;

    /**
     * 是否需要垫付 0否 1是
     */
    private String isDian;

    /**
     * 是否有预付款0否 1是
     */
    private String isYu;

    /**
     * 回款时间间距
     */
    private String timeInterval;

    /**
     * 软硬件报价比例
     */
    private Double rate;

    /**
     * 开票有无特殊需求0否 1是
     */
    private String isNeed;

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