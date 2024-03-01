package com.example.myapp.service.project.approval.quyu.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.approval.quyu.Quyu;
import com.example.myapp.service.project.approval.quyu.QuyuService;
import com.example.myapp.mapper.quyu.QuyuMapper;
import com.example.myapp.utils.BaseContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 *
 */
@Service
public class QuyuServiceImpl extends ServiceImpl<QuyuMapper, Quyu>
    implements QuyuService {

    @Override
    public boolean addApproval(Quyu quyu) {
        quyu.setApprovalBy(BaseContext.getCurrentUserAndUnion().getUserId());
        quyu.setApprovalTime(LocalDateTime.now());
        return save(quyu);
    }

    @Override
    public boolean updateApproval(Quyu quyu) {
        quyu.setApprovalBy(BaseContext.getCurrentUserAndUnion().getUserId());
        quyu.setApprovalTime(LocalDateTime.now());
        return updateById(quyu);
    }

    @Override
    public Quyu selectApproval(Integer baseId) {
        LambdaQueryWrapper<Quyu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Quyu::getBaseId,baseId);
        return getOne(wrapper);
    }
}




