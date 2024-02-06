package com.example.myapp.service;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.example.myapp.domain.dept.Dept;
import com.example.myapp.domain.employee.Employee;
import com.example.myapp.service.dept.DeptService;
import com.example.myapp.service.employee.EmployeeService;
import com.example.myapp.utils.JsonUtils;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("All")
@Slf4j
@Service
public class DeptAndUserService {

    private final AccessTokenService accessTokenService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    public DeptAndUserService(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }


    /**
     * 获取所有部门列表
     * @return
     * @throws ApiException
     */
    public List<Dept> departmentInfo() throws ApiException {
        //获取部门id
        /*DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/department/listsub");
        OapiV2DepartmentListsubidRequest req = new OapiV2DepartmentListsubidRequest();
        req.setDeptId(1L);
        OapiV2DepartmentListsubidResponse rsp = client.execute(req, accessTokenService.getAccessToken());
        System.out.println(rsp.getBody());*/


        List<Dept> list = selectTreeNodes(1L);
        List<Dept> tempList=new ArrayList<>();    // 创建一个临时列表用于保存要添加的元素
        list.stream().forEach(item->{
            try {
                List<Dept> list1 = selectTreeNodes(Long.valueOf(item.getId()));
                if(list1!=null){
                    tempList.addAll(list1);  // 将要添加的元素先保存到临时列表中
                }
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        });
        list.addAll(tempList);

        return list;

    }

    /**
     * 把给定的部门列表保存到数据库中
     */
    private void saveDepts(List<Dept> list){
        //todo  保存前先删除数据库中所有信息
        //保存所有部门信息到数据库中
        deptService.saveBatch(list);
    }

    /**
     * 根据deptId找到所有子部门（一级）
     * @param deptId
     * @return
     * @throws ApiException
     */
    @NotNull
    private List<Dept> selectTreeNodes(Long deptId) throws ApiException {

        List<Dept> list=new ArrayList<>();

        //获取部门全部信息
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/department/listsub");
        OapiV2DepartmentListsubRequest req = new OapiV2DepartmentListsubRequest();
        req.setDeptId(deptId);
        req.setLanguage("zh_CN");
        OapiV2DepartmentListsubResponse rsp = client.execute(req, accessTokenService.getAccessToken());
        System.out.println(rsp.getBody());

        //从返回结果中拿到部门信息并装入list集合中
        Map<String, Object> map = JsonUtils.convertJson2Map(rsp.getBody());
        List<Map<String, Object>> result = (List<Map<String, Object>>) map.get("result");

        result.stream().forEach(item->{
            Dept deptTreeDto = new Dept();

            deptTreeDto.setDeptName((String)item.get("name"));
            deptTreeDto.setId((Integer) item.get("dept_id"));

            deptTreeDto.setParentId((Integer) item.get("parent_id"));
            list.add(deptTreeDto);

        });
        return list;
    }

    /**
     * 获取所有部门人员信息并同步到user表中
     * @throws ApiException
     */
    public List<Employee> departmentUserInfo() throws ApiException {

        //获取所有部门的id集合
        List<Dept> deptInfo = departmentInfo();

        List<Employee> list=new ArrayList<>();

        //根据每个部门id查询到部门员工，并放入员工集合list中
        deptInfo.stream().forEach(item->{
            try {
//                List<Employee> tempList=new ArrayList<>();

                List<Employee> employees = getUserByDeptId(item.getId());
//                tempList.addAll(employees);
//                tempList.retainAll(list);
//                if(!tempList.isEmpty())
//                    System.err.println(tempList);

                System.out.println(employees);
                list.addAll(employees);

            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        });


        return list;

    }

    /**
     * 根据部门id来获取人员信息（不包含子部门）
     * @param deptId
     * @return
     * @throws ApiException
     */
    public List<Employee> getUserByDeptId(Integer deptId) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/list");
        OapiV2UserListRequest req = new OapiV2UserListRequest();

        req.setDeptId(deptId.longValue());
        req.setCursor(0L);
        req.setSize(100L);
        req.setOrderField("modify_desc");
        req.setContainAccessLimit(false);
        req.setLanguage("zh_CN");
        OapiV2UserListResponse rsp = client.execute(req, accessTokenService.getAccessToken());

        List<Employee> employees=new ArrayList<>();

        Map<String, Object> map = JsonUtils.convertJson2Map(rsp.getBody());
        Map<String, Object> result = (Map<String, Object>)map.get("result");
        List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("list");

        list.stream().forEach(item->{
            Employee employee = new Employee();
            String userid = (String) item.get("userid");
            String userName = (String) item.get("name");
            String position = (String) item.get("title");
            String phone = (String) item.get("mobile");
//            List<String> deptIdList = (List<String>) item.get("dept_id_list");
//            Integer deptid = Integer.parseInt(deptIdList.get(0));
            employee.setId(userid);
            employee.setUserName(userName);
            employee.setPosition(position);
            employee.setPhone(phone);
            employee.setDeptId(deptId);
//            System.out.println(deptId+"========"+deptid);
            employees.add(employee);
//            System.out.println(employee);
//            employeeService.save(employee);

        });
//        System.out.println(rsp.getBody());
        return employees;
    }
}
