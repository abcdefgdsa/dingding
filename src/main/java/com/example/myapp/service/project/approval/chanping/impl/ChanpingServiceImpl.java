package com.example.myapp.service.project.approval.chanping.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.approval.chanping.Chanping;
import com.example.myapp.service.project.approval.chanping.ChanpingService;
import com.example.myapp.mapper.chanping.ChanpingMapper;
import com.example.myapp.utils.BaseContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 *
 */
@Service
public class ChanpingServiceImpl extends ServiceImpl<ChanpingMapper, Chanping>
    implements ChanpingService {

    @Override
    public boolean addApproval(Chanping chanping) {
        chanping.setApprovalBy(BaseContext.getCurrentUserAndUnion().getUserId());
        chanping.setApprovalTime(LocalDateTime.now());
        return save(chanping);
    }

    @Override
    public boolean updateApproval(Chanping chanping) {
        chanping.setApprovalBy(BaseContext.getCurrentUserAndUnion().getUserId());
        chanping.setApprovalTime(LocalDateTime.now());
        return updateById(chanping);
    }

    @Override
    public Chanping selectApproval(Integer baseId) {
        LambdaQueryWrapper<Chanping> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Chanping::getBaseId,baseId);
        return getOne(wrapper);
    }
}




