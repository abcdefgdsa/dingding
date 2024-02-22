package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.approval.jiaofu.Jiaofu;
import com.example.myapp.service.project.approval.jiaofu.JiaofuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/jiaofu")
public class JiaofuController {

    @Autowired
    public JiaofuService jiaofuService;

    /**
     * 查询交付部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Jiaofu jiaofu =jiaofuService.selectApproval(baseId);
        return AjaxResult.success(jiaofu);
    }

    /**
     * 新增交付部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Jiaofu jiaofu) {
        boolean flag = jiaofuService.addApproval(jiaofu);
        if(flag)
            return AjaxResult.success("交付部评审添加成功");
        return AjaxResult.error("交付部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Jiaofu jiaofu) {
        boolean flag = jiaofuService.updateApproval(jiaofu);
        if(flag)
            return AjaxResult.success("交付部更新评审信息成功");
        return AjaxResult.error("交付部更新评审信息失败");
    }
}
