package com.example.myapp.service.project.approval.quyu;

import com.example.myapp.domain.project.approval.quyu.Quyu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface QuyuService extends IService<Quyu> {

    /**
     * 新增区域部评审信息
     */
    boolean addApproval(Quyu quyu);

    /**
     * 修改区域部评审信息
     */
    boolean updateApproval(Quyu quyu);


    /**
     * 根据基本项目信息id查询区域部评审信息
     */
    Quyu selectApproval(Integer baseId);
}
