package com.example.myapp.service.project.approval.shengtai.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.approval.shengtai.Shengtai;
import com.example.myapp.service.project.approval.shengtai.ShengtaiService;
import com.example.myapp.mapper.shengtai.ShengtaiMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ShengtaiServiceImpl extends ServiceImpl<ShengtaiMapper, Shengtai>
    implements ShengtaiService {

    @Override
    public boolean addApproval(Shengtai shengtai) {
        return save(shengtai);
    }

    @Override
    public boolean updateApproval(Shengtai shengtai) {
        return updateById(shengtai);
    }

    @Override
    public Shengtai selectApproval(Integer baseId) {
        LambdaQueryWrapper<Shengtai> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Shengtai::getBaseId,baseId);
        return getOne(wrapper);
    }
}




