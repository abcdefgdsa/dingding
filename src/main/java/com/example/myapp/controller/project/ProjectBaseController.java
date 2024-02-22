package com.example.myapp.controller.project;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.ProjectBase;
import com.example.myapp.service.project.ProjectBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/base")
public class ProjectBaseController {

    @Autowired
    public ProjectBaseService projectBaseService;

    /**
     * 查询项目信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(){
        List<ProjectBase> projectBases = projectBaseService.selectBase();
        return AjaxResult.success(projectBases);
    }

    /**
     * 新增项目信息
     */
    @PostMapping("/addBase")
    public AjaxResult addBase(@RequestBody ProjectBase projectBase) {
        boolean flag = projectBaseService.addBase(projectBase);
        if(flag)
            return AjaxResult.success("项目添加成功");
        return AjaxResult.error("项目添加失败");
    }

    /**
     * 根据项目id删除项目
     */
    @DeleteMapping("/delete/{baseId}")
    public AjaxResult deleteById(@PathVariable Integer baseId) {
        boolean flag = projectBaseService.deleteBase(baseId);
        if(flag)
            return AjaxResult.success("项目删除成功");
        return AjaxResult.error("该项目已被删除");
    }

    /**
     * 根据所给信息更新对应项目信息
     */
    @PutMapping("/updateBase")
    public AjaxResult updateDevice(@RequestBody ProjectBase projectBase) {
        boolean flag = projectBaseService.updateBase(projectBase);
        if(flag)
            return AjaxResult.success("更新项目信息成功");
        return AjaxResult.error("更新项目信息失败");
    }
}
