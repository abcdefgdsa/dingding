package com.example.myapp.service.project.approval.fangan;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myapp.domain.project.approval.fangan.Fangan;

/**
 *
 */
public interface FanganService extends IService<Fangan> {

    /**
     * 新增方案部评审信息
     */
    boolean addApproval(Fangan fangan);

    /**
     * 修改方案部评审信息
     */
    boolean updateApproval(Fangan fangan);


    /**
     * 根据基本项目信息id查询方案部评审信息
     */
    Fangan selectApproval(Integer baseId);

}
