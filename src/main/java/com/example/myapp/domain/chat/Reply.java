package com.example.myapp.domain.chat;

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
 * 回复表
 * @TableName reply
 */
@TableName(value ="reply")
@Data
public class Reply implements Serializable {
    /**
     * 回复表主键id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String replyId;

    /**
     * 前一条回复的id
     */
    private String frontId;


    /**
     * 内容
     */
    private String content;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 发布人名字
     */
    private String userName;

    /**
     * 回复时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}