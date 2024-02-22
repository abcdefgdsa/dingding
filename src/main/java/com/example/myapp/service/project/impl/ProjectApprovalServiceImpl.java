package com.example.myapp.service.project.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.ProjectApproval;
import com.example.myapp.service.project.ProjectApprovalService;
import com.example.myapp.mapper.project.ProjectApprovalMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ProjectApprovalServiceImpl extends ServiceImpl<ProjectApprovalMapper, ProjectApproval>
    implements ProjectApprovalService{

    @Override
    public boolean addApproval(ProjectApproval projectApproval) {
        return save(projectApproval);
    }

    @Override
    public boolean updateApproval(ProjectApproval projectApproval) {
        return updateById(projectApproval);
    }

    @Override
    public boolean deleteApproval(Integer approvalId) {

        return removeById(approvalId);
    }

    @Override
    public ProjectApproval selectApproval(Integer baseId) {
        LambdaQueryWrapper<ProjectApproval> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProjectApproval::getBaseId,baseId);
        return getOne(wrapper);
    }
}




