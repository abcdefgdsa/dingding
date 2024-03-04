package com.example.myapp.service.clientInfo;

import com.example.myapp.domain.clientInfo.ClientInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface ClientInfoService extends IService<ClientInfo> {

    /**
     * 根据客户名称来模糊查询返回所有符合的客户
     */
    List<ClientInfo>  selectByName(String name);

}
