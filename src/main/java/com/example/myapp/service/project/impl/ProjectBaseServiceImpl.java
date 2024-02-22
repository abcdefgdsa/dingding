package com.example.myapp.service.project.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.ProjectBase;
import com.example.myapp.service.project.ProjectBaseService;
import com.example.myapp.mapper.project.ProjectBaseMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
@Service
public class ProjectBaseServiceImpl extends ServiceImpl<ProjectBaseMapper, ProjectBase>
    implements ProjectBaseService{

    @Override
    public boolean addBase(ProjectBase projectBase) {
        projectBase.setCreateTime(LocalDateTime.now());
        //TODO 把员工的id也赋值进去
        return save(projectBase);
    }

    @Override
    public boolean updateBase(ProjectBase projectBase) {

        return updateById(projectBase);
    }

    @Override
    public boolean deleteBase(Integer baseId) {
        return removeById(baseId);
    }

    @Override
    public List<ProjectBase> selectBase() {
        //TODO 根据需求条件查询
        return list();
    }
}




