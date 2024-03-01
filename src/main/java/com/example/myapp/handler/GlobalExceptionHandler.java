package com.example.myapp.handler;

import com.example.myapp.domain.AjaxResult;
import com.example.myapp.exception.ApprovalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理器
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     */
    @ExceptionHandler(ApprovalException.class)
    public AjaxResult exceptionHandler(ApprovalException ex){
        log.error(ex.getMessage());

//        return AjaxResult.error(ex.getMessage());
        return AjaxResult.error("上个部门还未审批通过，未到您审批！");
    }
}