package com.simon.oj.dao.impl;

import com.simon.oj.dao.IProblemDao;
import com.simon.oj.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProblemDaoImpl implements IProblemDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
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
        List<Problem>list = jdbcTemplate.query("select * from problem",new Object[]{},new BeanPropertyRowMapper(Problem.class));
        if(list!=null&&list.size()>=1){
            return list;
        }else{
            return null;
        }
    }
}
