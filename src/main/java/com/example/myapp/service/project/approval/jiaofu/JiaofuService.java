package com.example.myapp.service.project.approval.jiaofu;

import com.example.myapp.domain.project.approval.jiaofu.Jiaofu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface JiaofuService extends IService<Jiaofu> {

    /**
     * 新增交付部评审信息
     */
    boolean addApproval(Jiaofu jiaofu);

    /**
     * 修改交付部评审信息
     */
    boolean updateApproval(Jiaofu jiaofu);


    /**
     * 根据基本项目信息id查询交付部评审信息
     */
    Jiaofu selectApproval(Integer baseId);

}
