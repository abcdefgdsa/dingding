package com.example.myapp.service.project.approval.chanping;

import com.example.myapp.domain.project.approval.chanping.Chanping;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface ChanpingService extends IService<Chanping> {

    /**
     * 新增产品部评审信息
     */
    boolean addApproval(Chanping chanping);

    /**
     * 修改产品部评审信息
     */
    boolean updateApproval(Chanping chanping);


    /**
     * 根据基本项目信息id查询产品部评审信息
     */
    Chanping selectApproval(Integer baseId);

}
