package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.approval.quyu.Quyu;
import com.example.myapp.service.project.approval.quyu.QuyuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/quyu")
public class QuyuController {

    @Autowired
    public QuyuService quyuService;

    /**
     * 查询区域部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Quyu quyu =quyuService.selectApproval(baseId);
        return AjaxResult.success(quyu);
    }

    /**
     * 新增区域部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Quyu quyu) {
        boolean flag = quyuService.addApproval(quyu);
        if(flag)
            return AjaxResult.success("区域部评审添加成功");
        return AjaxResult.error("区域部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Quyu quyu) {
        boolean flag = quyuService.updateApproval(quyu);
        if(flag)
            return AjaxResult.success("区域部更新评审信息成功");
        return AjaxResult.error("区域部更新评审信息失败");
    }
}
