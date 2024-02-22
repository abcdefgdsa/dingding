package com.example.myapp.service.project.approval.caiwu;

import com.example.myapp.domain.project.approval.caiwu.Caiwu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface CaiwuService extends IService<Caiwu> {

    /**
     * 新增财务部评审信息
     */
    boolean addApproval(Caiwu caiwu);

    /**
     * 修改财务部评审信息
     */
    boolean updateApproval(Caiwu caiwu);


    /**
     * 根据基本项目信息id查询财务部评审信息
     */
    Caiwu selectApproval(Integer baseId);

}
