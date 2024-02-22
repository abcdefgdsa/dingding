package com.example.myapp.service.project.approval.fangan.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.approval.fangan.Fangan;
import com.example.myapp.mapper.fangan.FanganMapper;
import com.example.myapp.service.project.approval.fangan.FanganService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class FanganServiceImpl extends ServiceImpl<FanganMapper, Fangan>
    implements FanganService {

    @Override
    public boolean addApproval(Fangan fangan) {
        return save(fangan);
    }

    @Override
    public boolean updateApproval(Fangan fangan) {
        return updateById(fangan);
    }

    @Override
    public Fangan selectApproval(Integer baseId) {
        LambdaQueryWrapper<Fangan> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Fangan::getBaseId,baseId);
        return getOne(wrapper);
    }
}




