package com.example.myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.SpringApplication;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({SpringApplication.class})
public class MyappApplicationTests {

	@Test
	public void mainRunSpringApplicationIfCommon() {
		PowerMockito.mockStatic(SpringApplication.class);

		String [] args = new String[0];
		MyappApplication.main(args);

		PowerMockito.verifyStatic();
		SpringApplication.run(MyappApplication.class, args);
	}

/*	@Test
	public void testCreateDbTable() {
		//默认创建方式
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		//通用的创建方式，指定配置文件名和Bean名称
//        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml", "processEngineConfiguration");
//        ProcessEngine processEngine1 = processEngineConfiguration.buildProcessEngine();
		System.out.println(processEngine);

	}

	@Test
	public void testDeployment(){
//        1、创建ProcessEngine
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        2、得到RepositoryService实例
		RepositoryService repositoryService = processEngine.getRepositoryService();
//        3、使用RepositoryService进行部署
		Deployment deployment = repositoryService.createDeployment()
				.addClasspathResource("bpmn/test.bpmn20.xml") // 添加bpmn资源
				//png资源命名是有规范的。Leave.myLeave.png|jpg|gif|svg  或者Leave.png|jpg|gif|svg
				.addClasspathResource("bpmn/test.png")  // 添加png资源
				.name("请假申请流程")
				.deploy();
//        4、输出部署信息
		System.out.println("流程部署id：" + deployment.getId());
		System.out.println("流程部署名称：" + deployment.getName());
	}*/

}
