package com.example.myapp.service.dept.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.dept.Dept;
import com.example.myapp.mapper.dept.DeptMapper;
import com.example.myapp.service.dept.DeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
}
