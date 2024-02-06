package com.example.myapp.service;


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
public class ClientService {

    private com.aliyun.dingtalkyida_1_0.Client client;

    @Autowired
    private ClientInfoService clientInfoService;

    private final AccessTokenService accessTokenService;

    @Autowired
    public ClientService(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }



    @PostConstruct
    public void init() throws Exception {
        Config config = new Config();
        config.protocol = "https";
        config.regionId = "central";
        client = new Client(config);
    }

    /**
     * 拉取宜搭上所有客户信息并同步到226的dingding数据库上
     * @return
     * @throws Exception
     */
    public String queryAllClients() throws Exception {

        //todo  只能分页查询出宜搭的数据，还需要循环几次查询，目前记录数300左右
        //todo  保存前先删除数据库中所有信息
        SearchFormDatasHeaders searchFormDatasHeaders = new SearchFormDatasHeaders();
        searchFormDatasHeaders.xAcsDingtalkAccessToken = accessTokenService.getAccessToken();
        SearchFormDatasRequest searchFormDatasRequest = new SearchFormDatasRequest()
                .setAppType("APP_LT2K23J8UEJCCWV7ZOAT")
                .setSystemToken("7F666S8119V8X69AE112H8M8GYIL38S37CZELP")
                .setUserId("0223043233301062376")
                .setLanguage("zh_CN")
                .setFormUuid("FORM-XN966G71FQV8142UEICW96ZL56FF2EYDBJ0FL5")
                .setCurrentPage(4)
                .setPageSize(100);
//                .setOriginatorId("1731111122223332")
//                .setCreateFromTimeGMT("2018-01-01")
//                .setCreateToTimeGMT("2018-02-01")
//                .setModifiedFromTimeGMT("2018-01-01")
//                .setModifiedToTimeGMT("2018-02-01")
//                .setDynamicOrder("{\"numberField_1ac\":\"+\"}, 表示按照字段numberField_1ac升序排列");
        try {
            SearchFormDatasResponse rsp = client.searchFormDatasWithOptions(searchFormDatasRequest, searchFormDatasHeaders, new RuntimeOptions());
            List<SearchFormDatasResponseBody.SearchFormDatasResponseBodyData> list = rsp.getBody().getData();
            System.err.println(list.get(1).getFormData());
            list.forEach(item->{
                ClientInfo clientInfo = new ClientInfo();
                Map<String, ?> data = item.getFormData();
                String id = (String)data.get("serialNumberField_lg4gwobc");
                String clientName = (String) data.get("textField_lf0jbx5t");
                String clientSource = (String) data.get("selectField_lngvtfnw");
                String addr = (String) data.get("addressField_lf0jbx6c_id");
                String addrMax = (String) data.get("addressField_lf0jbx6c_id");
                List<Map<String,Object>> tableList = (List<Map<String,Object>>)data.get("tableField_lf0jbx6n");
                Map<String, Object> map = tableList.get(0);
                String personName = (String) map.get("textField_lf0jbx6e");
                String personPhone = (String) map.get("textField_lf0jbx6h");
                String position = (String) map.get("textField_lf0jbx6f");
                String dept = (String) map.get("textField_lf0jbx6d");
                /*String personName = (String) data.get("textField_lf0jbx6e");
                String personPhone = (String) data.get("textField_lf0jbx6h");
                String position = (String) data.get("textField_lf0jbx6f");
                String dept = (String) data.get("textField_lf0jbx6d");*/
                String type = (String) data.get("selectField_lny0qzoc_id");
                String profess = (String) data.get("selectField_lny0wbgd_id");
                String isTeamwork = (String) data.get("radioField_lf0jbx6i_id");
                List<String> teamerList = (List<String>) data.get("employeeField_lj53hkb0_id");
                if(teamerList!=null) {
                    String teamer = teamerList.get(0);
                    clientInfo.setTeamer(teamer);
                }
                String createBy = (String) data.get("textField_lj53hkb1");
                clientInfo.setId(id);
                clientInfo.setClientName(clientName);
                clientInfo.setClientSource(clientSource);
                clientInfo.setAddr(addr);
                clientInfo.setAddrMax(addrMax);
                clientInfo.setPersonName(personName);
                clientInfo.setPersonPhone(personPhone);
                clientInfo.setPosition(position);
                clientInfo.setDept(dept);
                clientInfo.setType(type);
                clientInfo.setProfess(profess);
                clientInfo.setIsTeamwork(isTeamwork);
                clientInfo.setCreateBy(createBy);
                clientInfoService.save(clientInfo);

            });

            return null;
        } catch (TeaException err) {
            err.printStackTrace();
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
                System.err.println(err.getCode()+":"+err.getMessage());
            }

        } catch (Exception _err) {
            _err.printStackTrace();
            TeaException err = new TeaException(_err.getMessage(), _err);
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
                System.err.println(err.getCode()+":"+err.getMessage());


            }
        }
        return "error";
    }
}
