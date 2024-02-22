package com.example.myapp.controller.project;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.ProjectBase;
import com.example.myapp.domain.project.ProjectPrice;
import com.example.myapp.service.project.ProjectBaseService;
import com.example.myapp.service.project.ProjectPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/price")
public class ProjectPriceController {

    @Autowired
    public ProjectPriceService projectPriceService;

    /**
     * 查询报价信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(){
        List<ProjectPrice> projectPrices = projectPriceService.selectPrice();
        return AjaxResult.success(projectPrices);
    }

    /**
     * 新增报价信息
     */
    @PostMapping("/addPrice")
    public AjaxResult addPrice(@RequestBody ProjectPrice projectPrice) {
        boolean flag = projectPriceService.addPrice(projectPrice);
        if(flag)
            return AjaxResult.success("报价添加成功");
        return AjaxResult.error("报价添加失败");
    }

    /**
     * 根据报价id删除报价
     */
    @DeleteMapping("/delete/{priceId}")
    public AjaxResult deleteById(@PathVariable Integer priceId) {
        boolean flag = projectPriceService.deletePrice(priceId);
        if(flag)
            return AjaxResult.success("报价删除成功");
        return AjaxResult.error("该报价已被删除");
    }

    /**
     * 根据所给信息更新对应报价信息
     */
    @PutMapping("/updatePrice")
    public AjaxResult updatePrice(@RequestBody ProjectPrice projectPrice) {
        boolean flag = projectPriceService.updatePrice(projectPrice);
        if(flag)
            return AjaxResult.success("更新报价信息成功");
        return AjaxResult.error("更新报价信息失败");
    }
}
