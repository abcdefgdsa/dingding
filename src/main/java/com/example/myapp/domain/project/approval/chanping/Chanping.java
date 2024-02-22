package com.example.myapp.domain.project.approval.chanping;

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
 * 产品部审批
 * @TableName chanping
 */
@TableName(value ="chanping")
@Data
public class Chanping implements Serializable {
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
     * 公司现行产品匹配度 0完全匹配 1部分匹配
     */
    private String companyMatch;

    /**
     * 市场现行产品匹配度 0完全匹配 1部分匹配
     */
    private String marketMatch;

    /**
     * 是否符合行业标准 0否 1是
     */
    private String isStandard;

    /**
     * 是否已有明显控标参数产品  0否 1是
     */
    private String isProduct;

    /**
     * 有无定制开发需求 0否 1是
     */
    private String isCustom;

    /**
     *  有无外采需求 0否 1是
     */
    private String isOut;

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