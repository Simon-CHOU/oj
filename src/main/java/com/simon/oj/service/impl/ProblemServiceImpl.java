package com.simon.oj.service.impl;

import com.simon.oj.common.Result;
import com.simon.oj.common.ResultCode;
import com.simon.oj.dao.ProblemMapper;
import com.simon.oj.pojo.Problem;
import com.simon.oj.pojo.ProblemExample;
import com.simon.oj.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements IProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public Integer add(Problem problem) throws DataAccessException {

        return problemMapper.insert(problem);
    }

    @Override
    public Integer update(Problem problem)  throws DataAccessException {
        return problemMapper.updateByPrimaryKey(problem);
    }

    @Override
    public Integer delete(Integer id) throws DataAccessException{
        return problemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Problem findProblemById(Integer id) throws DataAccessException{
        return problemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Problem> findProblemList() throws DataAccessException{
        return problemMapper.selectByExample(new ProblemExample());
    }
}
