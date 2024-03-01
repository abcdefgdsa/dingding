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
 * 评论表
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
    /**
     * 评论表主键id
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String commentId;

    /**
     * 项目表id
     */
    private Integer baseId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 发布人id
     */
    private String userId;

    /**
     * 发布人名字
     */
    private String userName;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}