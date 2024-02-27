package com.example.myapp.exception;

/**
 * 自定义业务异常类
 */
public class ApprovalException extends RuntimeException{
    public ApprovalException(String message){
        super(message);
    }
}
