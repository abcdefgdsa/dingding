package com.example.myapp.service.project.approval.pingtai;

import com.example.myapp.domain.project.approval.pingtai.Pingtai;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface PingtaiService extends IService<Pingtai> {

    /**
     * 新增平台部评审信息
     */
    boolean addApproval(Pingtai pingtai);

    /**
     * 修改平台部评审信息
     */
    boolean updateApproval(Pingtai pingtai);


    /**
     * 根据基本项目信息id查询平台部评审信息
     */
    Pingtai selectApproval(Integer baseId);

}
