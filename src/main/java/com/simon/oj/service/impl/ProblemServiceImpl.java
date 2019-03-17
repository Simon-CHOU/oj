package com.simon.oj.service.impl;

import com.simon.oj.dao.IProblemDao;
import com.simon.oj.dao.impl.ProblemDaoImpl;
import com.simon.oj.model.Problem;
import com.simon.oj.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements IProblemService {
    @Autowired
    IProblemDao problemDao;

    @Override
    public int add(Problem problem) {
        return 0;
    }

    @Override
    public int update(Problem problem) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Problem findProblemById() {
        return null;
    }

    @Override
    public List<Problem> findProblemList() {
        return problemDao.findProblemList();
    }
}
