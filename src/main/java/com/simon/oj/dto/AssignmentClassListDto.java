package com.simon.oj.dto;

import lombok.Data;

import java.util.List;


/**
 * 作业id-班级id列表实体，
 * 用于作业下发班级功能
 */
@Data
public class AssignmentClassListDto {
    private Integer idassignment;//作业Id
    List<Integer> idClassList;//班级Id列表
}
/*
前端传递如下的JSON
{
    "idclasslist": [1,2],
    "idassignment": "1"
}
 */