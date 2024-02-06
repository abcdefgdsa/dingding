package com.example.myapp.domain.dept;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptTreeDto extends Dept {

    //子节点
    List<DeptTreeDto> childrenTreeNodes;
}
