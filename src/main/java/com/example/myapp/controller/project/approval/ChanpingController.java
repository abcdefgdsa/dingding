package com.example.myapp.controller.project.approval;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.project.approval.chanping.Chanping;
import com.example.myapp.service.project.approval.chanping.ChanpingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/chanping")
public class ChanpingController {

    @Autowired
    public ChanpingService chanpingService;

    /**
     * 查询产品部评审信息
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        Chanping chanping =chanpingService.selectApproval(baseId);
        return AjaxResult.success(chanping);
    }

    /**
     * 新增产品部评审信息
     */
    @PostMapping("/addApproval")
    public AjaxResult addApproval(@RequestBody Chanping chanping) {
        boolean flag = chanpingService.addApproval(chanping);
        if(flag)
            return AjaxResult.success("产品部评审添加成功");
        return AjaxResult.error("产品部评审添加失败");
    }


    /**
     * 根据所给信息更新对应评审信息
     */
    @PutMapping("/updateApproval")
    public AjaxResult updateApproval(@RequestBody Chanping chanping) {
        boolean flag = chanpingService.updateApproval(chanping);
        if(flag)
            return AjaxResult.success("产品部更新评审信息成功");
        return AjaxResult.error("产品部更新评审信息失败");
    }
}
