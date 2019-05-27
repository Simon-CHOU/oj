package com.simon.oj.service.impl;

import com.simon.oj.dao.SubmitMapper;
import com.simon.oj.pojo.Submit;
import com.simon.oj.pojo.SubmitExample;
import com.simon.oj.service.ISubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitServiceImpl implements ISubmitService {
    @Autowired
    private SubmitMapper submitMapper;

    @Override
    public List<Submit> findSubmitList() {
        return submitMapper.selectByExample(new SubmitExample());
    }

    @Override
    public Submit findSubmitById(Integer id) {
        return submitMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer add(Submit submit) {
        return submitMapper.insert(submit);
    }

    @Override
    public Integer update(Submit submit) {
        return submitMapper.updateByPrimaryKey(submit);
    }

    @Override
    public Integer delete(Integer id) {
        return submitMapper.deleteByPrimaryKey(id);
    }
}
