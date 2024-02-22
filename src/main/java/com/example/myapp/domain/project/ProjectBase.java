package com.example.myapp.domain.project;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @TableName project_base
 */
@TableName(value ="project_base")
@Data
public class ProjectBase implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String clientManager;

    private String projectManager;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate initDate;

    private String projectName;

    private String baseInfo;

    private String moneySource;

    private String mainProduct;

    private String examTime;

    private String projectStage;

    private String projectFrom;

    private String clientName;

    private String tenderUnit;

    private String tenderPerson;

    private String tenderDept;

    private String useUnit;

    private String usePerson;

    private String useDept;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate predictTime;

    private String signUnit;

    private String type;

    private String codeNeeds;

    private String description;

    private String file;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableLogic(value = "0",delval = "1")
    private String deleteStatus;

    private static final long serialVersionUID = 1L;


}