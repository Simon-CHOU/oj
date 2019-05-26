package com.simon.oj.service;

import com.simon.oj.pojo.Problem;

import java.util.List;

public interface IProblemService {
    Problem findProblemById(Integer id);
    List<Problem> findProblemList();
    Integer add(Problem problem);//字段太多所以传对象
    Integer update(Problem problem);
    Integer delete(Integer id);
}
