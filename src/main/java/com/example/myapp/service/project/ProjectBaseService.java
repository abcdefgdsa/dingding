package com.example.myapp.service.project;

import com.example.myapp.domain.project.ProjectBase;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface ProjectBaseService extends IService<ProjectBase> {

    /**
     * 新增项目基础信息
     * @param projectBase
     * @return
     */
    boolean addBase(ProjectBase projectBase);

    /**
     * 修改项目基础信息
     */
    boolean updateBase(ProjectBase projectBase);

    /**
     * 删除项目信息
     */
    boolean deleteBase(Integer baseId);

    /**
     * 查询项目信息
     */
    List<ProjectBase> selectBase();
}
