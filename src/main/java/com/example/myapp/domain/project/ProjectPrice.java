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
 * 项目报价表
 * @TableName project_price
 */
@TableName(value ="project_price")
@Data
public class ProjectPrice implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;


    /**
     *项目基础信息表id
     */
    private Integer baseId;
    /**
     * 报价文件
     */
    private String file;

    /**
     * 1交付 2方案
     */
    private String makeDept;

    /**
     * 报价金额
     */
    private BigDecimal price;

    /**
     * 确认人
     */
    private String confirmBy;

    /**
     *  确认日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate confirmDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}