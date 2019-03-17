package com.simon.oj.service;

import com.simon.oj.model.Problem;

import java.util.List;

public interface IProblemService {
    int add(Problem problem);
    int update(Problem problem);
    int delete(int id);
    Problem findProblemById();
    List<Problem> findProblemList();
}
