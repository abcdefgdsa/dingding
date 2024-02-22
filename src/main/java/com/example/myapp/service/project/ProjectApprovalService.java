package com.example.myapp.service.project;

import com.example.myapp.domain.project.ProjectApproval;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myapp.domain.project.ProjectPrice;

import java.util.List;

/**
 *
 */
public interface ProjectApprovalService extends IService<ProjectApproval> {

    /**
     * 新增评审信息
     */
    boolean addApproval(ProjectApproval projectApproval);

    /**
     * 修改评审信息
     */
    boolean updateApproval(ProjectApproval projectApproval);

    /**
     * 删除评审信息
     */
    boolean deleteApproval(Integer approvalId);

    /**
     * 根据基本项目信息查询评审信息
     */
    ProjectApproval selectApproval(Integer baseId);

}
