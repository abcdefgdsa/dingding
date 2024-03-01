package com.example.myapp.domain.process;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 审批流程
 * @TableName process
 */
@TableName(value ="process")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Process implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目表id
     */
    private Integer baseId;

    /**
     * 部门表id
     */
    private String deptId;

    /**
     * 部门名
     */
    private String deptName;

    /**
     * 审批人id
     */
    private String approvalBy;

    /**
     * 审批意见  3未到时间审批 2正在审批  1通过 0不通过
     */
    private String approvalStatus;

    /**
     * 审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime approvalTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}