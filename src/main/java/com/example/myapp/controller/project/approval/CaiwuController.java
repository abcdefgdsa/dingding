package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.approval.caiwu.Caiwu;
import com.example.myapp.service.project.approval.caiwu.CaiwuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/caiwu")
public class CaiwuController {

    @Autowired
    public CaiwuService caiwuService;

    /**
     * 查询财务部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Caiwu caiwu =caiwuService.selectApproval(baseId);
        return AjaxResult.success(caiwu);
    }

    /**
     * 新增财务部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Caiwu caiwu) {
        boolean flag = caiwuService.addApproval(caiwu);
        if(flag)
            return AjaxResult.success("财务部评审添加成功");
        return AjaxResult.error("财务部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Caiwu caiwu) {
        boolean flag = caiwuService.updateApproval(caiwu);
        if(flag)
            return AjaxResult.success("财务部更新评审信息成功");
        return AjaxResult.error("财务部更新评审信息失败");
    }
}
