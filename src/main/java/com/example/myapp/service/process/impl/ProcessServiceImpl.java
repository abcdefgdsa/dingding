package com.example.myapp.service.process.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.process.Process;
import com.example.myapp.service.process.ProcessService;
import com.example.myapp.mapper.process.ProcessMapper;
import com.example.myapp.utils.BaseContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Service
public class ProcessServiceImpl extends ServiceImpl<ProcessMapper, Process>
    implements ProcessService{

    @Override
    public void createProcess(Integer baseId) {
        List<Process> list = Arrays.asList(
                new Process(null, baseId, "661261433", "平台部", "", "", null),
                new Process(null, baseId, "661262569", "产品部", "", "", null),
                new Process(null, baseId, "107770190", "方案部", "", "", null),
                new Process(null, baseId, "545142099", "交付部", "", "", null),
                new Process(null, baseId, "662228237", "区域部", "", "", null),
                new Process(null, baseId, "905992062", "生态部", "", "", null),
                new Process(null, baseId, "905992062", "生态部", "", "", null),
                new Process(null, baseId, "107770081", "财务部", "", "", null),
                new Process(null, baseId, "107770310", "商务部", "", "", null)
                );
        saveBatch(list);
    }

    @Override
    public List<Process> selectByBaseId(Integer baseId) {
        LambdaQueryWrapper<Process> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Process::getBaseId,baseId);
        return list(wrapper);
    }


    @Override
    public boolean updateApproval(Process process) {

        UpdateWrapper<Process> wrapper = new UpdateWrapper<>();
//        wrapper.set("approval_by", BaseContext.getCurrentUserAndUnion().getUserId());
//        wrapper.set("approval_status",process.getApprovalStatus());
        wrapper.eq("base_id",process.getBaseId());
        wrapper.eq("dept_id",process.getDeptId());
        return update(process,wrapper);

    }
}




