package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.approval.pingtai.Pingtai;
import com.example.myapp.service.project.approval.pingtai.PingtaiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/pingtai")
public class PingtaiController {

    @Autowired
    public PingtaiService pingtaiService;

    /**
     * 查询平台部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Pingtai pingtai =pingtaiService.selectApproval(baseId);
        return AjaxResult.success(pingtai);
    }

    /**
     * 新增平台部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Pingtai pingtai) {
        boolean flag = pingtaiService.addApproval(pingtai);
        if(flag)
            return AjaxResult.success("平台部评审添加成功");
        return AjaxResult.error("平台部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Pingtai pingtai) {
        boolean flag = pingtaiService.updateApproval(pingtai);
        if(flag)
            return AjaxResult.success("平台部更新评审信息成功");
        return AjaxResult.error("平台部更新评审信息失败");
    }
}
