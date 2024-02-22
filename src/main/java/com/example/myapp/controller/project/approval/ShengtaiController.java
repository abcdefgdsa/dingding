package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.approval.shengtai.Shengtai;
import com.example.myapp.service.project.approval.shengtai.ShengtaiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/shengtai")
public class ShengtaiController {

    @Autowired
    public ShengtaiService shengtaiService;

    /**
     * 查询生态部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Shengtai shengtai =shengtaiService.selectApproval(baseId);
        return AjaxResult.success(shengtai);
    }

    /**
     * 新增生态部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Shengtai shengtai) {
        boolean flag = shengtaiService.addApproval(shengtai);
        if(flag)
            return AjaxResult.success("生态部评审添加成功");
        return AjaxResult.error("生态部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Shengtai shengtai) {
        boolean flag = shengtaiService.updateApproval(shengtai);
        if(flag)
            return AjaxResult.success("生态部更新评审信息成功");
        return AjaxResult.error("生态部更新评审信息失败");
    }
}
