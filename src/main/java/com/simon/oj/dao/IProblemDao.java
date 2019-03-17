package com.simon.oj.dao;

import com.simon.oj.model.Problem;

import java.util.List;

public interface IProblemDao {
    int add(Problem problem);
    int update(Problem problem);
    int delete(int id);
    Problem findProblemById();
    List<Problem> findProblemList();

}
