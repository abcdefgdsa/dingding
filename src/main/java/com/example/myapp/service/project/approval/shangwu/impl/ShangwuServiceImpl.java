package com.example.myapp.service.project.approval.shangwu.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.approval.shangwu.Shangwu;
import com.example.myapp.service.project.approval.shangwu.ShangwuService;
import com.example.myapp.mapper.shangwu.ShangwuMapper;
import com.example.myapp.utils.BaseContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 *
 */
@Service
public class ShangwuServiceImpl extends ServiceImpl<ShangwuMapper, Shangwu>
    implements ShangwuService {

    @Override
    public boolean addApproval(Shangwu shangwu) {
        shangwu.setApprovalBy(BaseContext.getCurrentUserAndUnion().getUserId());
        shangwu.setApprovalTime(LocalDateTime.now());
        return save(shangwu);
    }

    @Override
    public boolean updateApproval(Shangwu shangwu) {
        shangwu.setApprovalBy(BaseContext.getCurrentUserAndUnion().getUserId());
        shangwu.setApprovalTime(LocalDateTime.now());
        return updateById(shangwu);
    }

    @Override
    public Shangwu selectApproval(Integer baseId) {
        LambdaQueryWrapper<Shangwu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Shangwu::getBaseId,baseId);
        return getOne(wrapper);
    }
}




