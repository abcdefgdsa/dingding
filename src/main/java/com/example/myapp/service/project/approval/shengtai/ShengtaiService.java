package com.example.myapp.service.project.approval.shengtai;

import com.example.myapp.domain.project.approval.shengtai.Shengtai;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface ShengtaiService extends IService<Shengtai> {

    /**
     * 新增生态部评审信息
     */
    boolean addApproval(Shengtai shengtai);

    /**
     * 修改生态部评审信息
     */
    boolean updateApproval(Shengtai shengtai);


    /**
     * 根据基本项目信息id查询生态部评审信息
     */
    Shengtai selectApproval(Integer baseId);

}
