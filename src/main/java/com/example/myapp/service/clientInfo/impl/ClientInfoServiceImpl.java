package com.example.myapp.service.clientInfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.clientInfo.ClientInfo;
import com.example.myapp.service.clientInfo.ClientInfoService;
import com.example.myapp.mapper.clientInfo.ClientInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *
 */
@Service
public class ClientInfoServiceImpl extends ServiceImpl<ClientInfoMapper, ClientInfo>
    implements ClientInfoService{

    @Override
    public List<ClientInfo> selectByName(String name) {
        LambdaQueryWrapper<ClientInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(name),ClientInfo::getClientName,name);
        return list(wrapper);
    }
}




