package com.example.myapp.service.clientInfo.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.clientInfo.ClientInfo;
import com.example.myapp.service.clientInfo.ClientInfoService;
import com.example.myapp.mapper.clientInfo.ClientInfoMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ClientInfoServiceImpl extends ServiceImpl<ClientInfoMapper, ClientInfo>
    implements ClientInfoService{

}




