package com.example.myapp.service.process;

import com.example.myapp.domain.process.Process;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface ProcessService extends IService<Process> {

    /**
     * 新增流程图
     * @param baseId
     */
    void createProcess(Integer baseId);

    /**
     * 根据项目id查询流程图
     */
    List<Process> selectByBaseId(Integer baseId);

    /**
     * 修改审批状态  通过或不通过
     */
    boolean updateApproval(Process process);

}
