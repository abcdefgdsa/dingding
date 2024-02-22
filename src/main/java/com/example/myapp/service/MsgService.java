package com.example.myapp.service;


import com.aliyun.dingtalkrobot_1_0.models.BatchSendOTOHeaders;
import com.aliyun.dingtalkrobot_1_0.models.BatchSendOTORequest;
import com.aliyun.dingtalkyida_1_0.Client;
import com.aliyun.dingtalkyida_1_0.models.SearchFormDatasHeaders;
import com.aliyun.dingtalkyida_1_0.models.SearchFormDatasRequest;
import com.aliyun.dingtalkyida_1_0.models.SearchFormDatasResponse;
import com.aliyun.dingtalkyida_1_0.models.SearchFormDatasResponseBody;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import com.example.myapp.domain.clientInfo.ClientInfo;
import com.example.myapp.service.clientInfo.ClientInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class MsgService {

    private final AccessTokenService accessTokenService;

    @Autowired
    public MsgService(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }

    /**
     * 使用 Token 初始化账号Client
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dingtalkrobot_1_0.Client createClient() throws Exception {
        Config config = new Config();
        config.protocol = "https";
        config.regionId = "central";
        return new com.aliyun.dingtalkrobot_1_0.Client(config);
    }


  /*  @PostConstruct
    public void init() throws Exception {
        Config config = new Config();
        config.protocol = "https";
        config.regionId = "central";
        client = new Client(config);
    }*/

    /**
     * 机器人发消息到钉钉
     */
    public String sendMsg(String userId,String msg) throws Exception {
        com.aliyun.dingtalkrobot_1_0.Client client = MsgService.createClient();
        BatchSendOTOHeaders batchSendOTOHeaders = new BatchSendOTOHeaders();
        batchSendOTOHeaders.xAcsDingtalkAccessToken = accessTokenService.getAccessToken();
        BatchSendOTORequest batchSendOTORequest = new BatchSendOTORequest()
                .setRobotCode("ding1kut0msr8vrstzym")
                .setUserIds(java.util.Arrays.asList(
                        userId
                ))
                .setMsgKey("sampleText")
                .setMsgParam("{" + "\"content\": \""+msg+"\"" + "}");
        try {
            client.batchSendOTOWithOptions(batchSendOTORequest, batchSendOTOHeaders, new RuntimeOptions());
        } catch (TeaException err) {
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
            }

        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
            }

        }
        return null;
    }
}
