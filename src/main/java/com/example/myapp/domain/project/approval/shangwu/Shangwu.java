package com.example.myapp.domain.project.approval.shangwu;

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
 * 商务部审批
 * @TableName shangwu
 */
@TableName(value ="shangwu")
@Data
public class Shangwu implements Serializable {
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
     * 是否通过投标落地，是则签订项目合作协议书为前提 0否1是
     */
    private String isSign;

    /**
     * 报备同时需备库存，提供需求清单和建议清单包括可供可选清单 0否1是
     */
    private String isNeed;

    /**
     * 首付
     */;
    private Integer first;

    /**
     * 设备到货
     */
    private Integer arrive;

    /**
     * 系统上线验收
     */
    private Integer online;

    /**
     * 质保金
     */
    private Integer promise;

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