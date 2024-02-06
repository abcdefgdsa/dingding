package com.example.myapp.mapper.dept;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.myapp.domain.dept.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
