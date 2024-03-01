package com.example.myapp.utils;

import com.example.myapp.domain.MyValues;

/**
 * 基于ThreadLocal封装工具类，用于保存和获取当前登录用户的userId和unionId
 */
public class BaseContext {

    private static ThreadLocal<MyValues> threadLocal=new ThreadLocal<>();

    public static void setCurrentUserAndUnion(String userId,String userName,String unionId){
        threadLocal.set(new MyValues(userId,userName,unionId));
    }

    public static MyValues getCurrentUserAndUnion(){
        return threadLocal.get();
    }
}
