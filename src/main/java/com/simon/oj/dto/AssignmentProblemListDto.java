package com.simon.oj.dto;

import lombok.Data;

import java.util.List;

/**
 * 作业id-题目id列表实体类
 * 用来增删改一份作业包含的题目
 */
@Data
public class AssignmentProblemListDto {
    private Integer idassignment;//作业Id
    private List<Integer> idProblemList;//题目Id列表
}
