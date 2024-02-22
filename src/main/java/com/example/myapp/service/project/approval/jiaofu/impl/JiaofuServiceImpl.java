package com.example.myapp.service.project.approval.jiaofu.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.approval.jiaofu.Jiaofu;
import com.example.myapp.service.project.approval.jiaofu.JiaofuService;
import com.example.myapp.mapper.jiaofu.JiaofuMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class JiaofuServiceImpl extends ServiceImpl<JiaofuMapper, Jiaofu>
    implements JiaofuService{

    @Override
    public boolean addApproval(Jiaofu jiaofu) {
        return save(jiaofu);
    }

    @Override
    public boolean updateApproval(Jiaofu jiaofu) {
        return updateById(jiaofu);
    }

    @Override
    public Jiaofu selectApproval(Integer baseId) {
        LambdaQueryWrapper<Jiaofu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Jiaofu::getBaseId,baseId);
        return getOne(wrapper);
    }
}




