package com.example.myapp.domain.instance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目id和对应该项目的流程实例id做映射
 * @TableName project_instance
 */
@TableName(value ="project_instance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInstance implements Serializable {
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
     * 流程实例id
     */
    private String instanceId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}