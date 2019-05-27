package com.simon.oj.service.impl;

import com.simon.oj.dao.ClassUMapper;
import com.simon.oj.pojo.ClassU;
import com.simon.oj.pojo.ClassUExample;
import com.simon.oj.service.IClassUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassUServiceImpl implements IClassUService {
    @Autowired
    private ClassUMapper classUMapper;

    @Override
    public ClassU findClassUById(Integer id) {
        return classUMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ClassU> findClassUList() {
        return classUMapper.selectByExample(new ClassUExample());
    }

    @Override
    public Integer add(ClassU classu) {
        return classUMapper.insert(classu);
    }

    @Override
    public Integer update(ClassU classu) {
        return classUMapper.updateByPrimaryKey(classu);
    }

    @Override
    public Integer delete(Integer id) {
        return classUMapper.deleteByPrimaryKey(id);
    }
}
