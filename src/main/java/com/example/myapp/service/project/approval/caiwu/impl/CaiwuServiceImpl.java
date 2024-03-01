package com.example.myapp.service.project.approval.caiwu.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.approval.caiwu.Caiwu;
import com.example.myapp.service.project.approval.caiwu.CaiwuService;
import com.example.myapp.mapper.caiwu.CaiwuMapper;
import com.example.myapp.utils.BaseContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 *
 */
@Service
public class CaiwuServiceImpl extends ServiceImpl<CaiwuMapper, Caiwu>
    implements CaiwuService{

    @Override
    public boolean addApproval(Caiwu caiwu) {

        caiwu.setApprovalBy(BaseContext.getCurrentUserAndUnion().getUserId());
        caiwu.setApprovalTime(LocalDateTime.now());
        return save(caiwu);
    }

    @Override
    public boolean updateApproval(Caiwu caiwu) {

        caiwu.setApprovalBy(BaseContext.getCurrentUserAndUnion().getUserId());
        caiwu.setApprovalTime(LocalDateTime.now());
        return updateById(caiwu);
    }

    @Override
    public Caiwu selectApproval(Integer baseId) {
        LambdaQueryWrapper<Caiwu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Caiwu::getBaseId,baseId);
        return getOne(wrapper);
    }
}




