package com.example.myapp.service.instance;

import com.example.myapp.domain.instance.ProjectInstance;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface ProjectInstanceService extends IService<ProjectInstance> {


    /**
     * 根据项目id来查询流程实例id
     */
    ProjectInstance selectByBaseId(Integer baseId);

    /**
     * 新增项目id和流程实例id的映射
     */
    boolean addInstance(ProjectInstance projectInstance);
}
