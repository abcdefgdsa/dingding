package com.example.myapp.service.instance.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.instance.ProjectInstance;
import com.example.myapp.service.instance.ProjectInstanceService;
import com.example.myapp.mapper.instance.ProjectInstanceMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProjectInstanceServiceImpl extends ServiceImpl<ProjectInstanceMapper, ProjectInstance>
    implements ProjectInstanceService{

    @Override
    public ProjectInstance selectByBaseId(Integer baseId) {
        LambdaQueryWrapper<ProjectInstance> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ProjectInstance::getBaseId,baseId);

        return getOne(wrapper);
    }

    @Override
    public boolean addInstance(ProjectInstance projectInstance) {

        return save(projectInstance);
    }
}




