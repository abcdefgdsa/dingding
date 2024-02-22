package com.example.myapp.domain.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 立项评审表
 * @TableName project_approval
 */
@TableName(value ="project_approval")
@Data
public class ProjectApproval implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目基础信息表id
     */
    private Integer baseId;

    /**
     * 合同协议
     */
    private String file;

    /**
     * 合同金额
     */
    private BigDecimal price;

    /**
     * 制作人
     */
    private String makeBy;

    /**
     * 制作日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate makeDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}