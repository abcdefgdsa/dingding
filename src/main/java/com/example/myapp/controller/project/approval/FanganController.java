package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.approval.fangan.Fangan;
import com.example.myapp.service.project.approval.fangan.FanganService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/fangan")
public class FanganController {

    @Autowired
    public FanganService fanganService;

    /**
     * 查询方案部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Fangan fangan =fanganService.selectApproval(baseId);
        return AjaxResult.success(fangan);
    }

    /**
     * 新增方案部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Fangan fangan) {
        boolean flag = fanganService.addApproval(fangan);
        if(flag)
            return AjaxResult.success("方案部评审添加成功");
        return AjaxResult.error("方案部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Fangan fangan) {
        boolean flag = fanganService.updateApproval(fangan);
        if(flag)
            return AjaxResult.success("方案部更新评审信息成功");
        return AjaxResult.error("方案部更新评审信息失败");
    }
}
