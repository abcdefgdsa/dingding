package com.example.myapp.service.project.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.project.ProjectPrice;
import com.example.myapp.service.project.ProjectPriceService;
import com.example.myapp.mapper.project.ProjectPriceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ProjectPriceServiceImpl extends ServiceImpl<ProjectPriceMapper, ProjectPrice>
    implements ProjectPriceService{

    @Override
    public boolean addPrice(ProjectPrice projectPrice) {
        return save(projectPrice);
    }

    @Override
    public boolean updatePrice(ProjectPrice projectPrice) {
        return updateById(projectPrice);
    }

    @Override
    public boolean deletePrice(Integer priceId) {
        return removeById(priceId);
    }

    @Override
    public List<ProjectPrice> selectPrice() {
        //TODO 根据需求条件查询
        return list();
    }
}




