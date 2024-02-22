package com.example.myapp.service.project;

import com.example.myapp.domain.project.ProjectBase;
import com.example.myapp.domain.project.ProjectPrice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface ProjectPriceService extends IService<ProjectPrice> {

    /**
     * 新增报价信息
     */
    boolean addPrice(ProjectPrice projectPrice);

    /**
     * 修改报价信息
     */
    boolean updatePrice(ProjectPrice projectPrice);

    /**
     * 删除报价信息
     */
    boolean deletePrice(Integer priceId);

    /**
     * 查询报价信息
     */
    List<ProjectPrice> selectPrice();
}
