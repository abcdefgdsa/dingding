package com.example.myapp.service.project.approval.pingtai.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.approval.pingtai.Pingtai;
import com.example.myapp.service.project.approval.pingtai.PingtaiService;
import com.example.myapp.mapper.pingtai.PingtaiMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PingtaiServiceImpl extends ServiceImpl<PingtaiMapper, Pingtai> implements PingtaiService{

    @Override
    public boolean addApproval(Pingtai pingtai) {
        return save(pingtai);
    }

    @Override
    public boolean updateApproval(Pingtai pingtai) {
        return updateById(pingtai);
    }

    @Override
    public Pingtai selectApproval(Integer baseId) {
        LambdaQueryWrapper<Pingtai> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Pingtai::getBaseId,baseId);
        return getOne(wrapper);
    }
}




