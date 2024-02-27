package com.example.myapp.service;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Activiti业务层
 */
@Service
public class ActivitiService {


    /**
     * 启动流程实例
     */
    public void ProcessBoot(Integer businessKey){
        // 1、创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        2、获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
//        3、根据流程定义Id启动流程
        org.activiti.engine.runtime.ProcessInstance processInstance = runtimeService
                //将项目的id存入此次流程中
                .startProcessInstanceByKey("myProject",businessKey+"");
//        输出内容
        System.out.println("流程定义id：" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例id：" + processInstance.getId());
        System.out.println("当前活动Id：" + processInstance.getActivityId());
    }

    /**
     * 完成个人任务，这里的参数表示部门id
     */
    public void completTask(String assingee){
//        流程定义的Key
        String key = "myProject";
//        任务负责人
//        String assingee = "61231";
        //        获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        获取taskservice
        TaskService taskService = processEngine.getTaskService();
//        查询任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee(assingee)
                //todo  目前只考虑一个项目,多个项目需要审批时要做区分
                .singleResult();
        if(task != null){
            //     根据任务id来   完成任务
            taskService.complete(task.getId());
            System.out.println(task.getId()+"----任务已完成");
        }else{

            //TODO 若没轮到该节点审批，则抛出异常
            System.out.println("抛出异常，现在还没到你审批");
        }

    }

    /**
     * 查询所有流程目前待执行的任务,目前只考虑单个
     */

    public void queryTask(){
//        流程定义的Key
        String key = "myProject";

        //        获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        获取taskservice
        TaskService taskService = processEngine.getTaskService();
//        查询任务
        final List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey(key)
//                .taskAssignee(assingee)
                .list();
        for(Task task:tasks){
            //     根据任务id来   完成任务
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getAssignee());
        }

    }
    /**
     * 部署流程定义
     */
/*    public void testDeployment(){
//        1、创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        2、得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
//        3、使用RepositoryService进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/test.bpmn20.xml") // 添加bpmn资源
                //png资源命名是有规范的。Leave.myLeave.png|jpg|gif|svg  或者Leave.png|jpg|gif|svg
//                .addClasspathResource("bpmn/test.png")  // 添加png资源
                .name("项目立项审批流程")
                .deploy();
//        4、输出部署信息
        System.err.println("项目立项审批流程部署完毕！");
        System.err.println("流程部署id：" + deployment.getId());
        System.err.println("流程部署名称：" + deployment.getName());
    }*/


}