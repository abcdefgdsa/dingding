package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.approval.shangwu.Shangwu;
import com.example.myapp.service.project.approval.shangwu.ShangwuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/shangwu")
public class ShangwuController {

    @Autowired
    public ShangwuService shangwuService;

    /**
     * 查询商务部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Shangwu shangwu =shangwuService.selectApproval(baseId);
        return AjaxResult.success(shangwu);
    }

    /**
     * 新增商务部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Shangwu shangwu) {
        boolean flag = shangwuService.addApproval(shangwu);
        if(flag)
            return AjaxResult.success("商务部评审添加成功");
        return AjaxResult.error("商务部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Shangwu shangwu) {
        boolean flag = shangwuService.updateApproval(shangwu);
        if(flag)
            return AjaxResult.success("商务部更新评审信息成功");
        return AjaxResult.error("商务部更新评审信息失败");
    }
}
