package com.example.myapp.service.project.approval.shangwu;

import com.example.myapp.domain.project.approval.shangwu.Shangwu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface ShangwuService extends IService<Shangwu> {

    /**
     * 新增商务部评审信息
     */
    boolean addApproval(Shangwu shangwu);

    /**
     * 修改商务部评审信息
     */
    boolean updateApproval(Shangwu shangwu);


    /**
     * 根据基本项目信息id查询商务部评审信息
     */
    Shangwu selectApproval(Integer baseId);
}
