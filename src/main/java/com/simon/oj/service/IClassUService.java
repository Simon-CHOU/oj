package com.simon.oj.service;

import com.simon.oj.pojo.ClassU;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClassUService {
    ClassU findClassUById(Integer id);
    List<ClassU> findClassUList();
    Integer add(ClassU classu);//字段太多所以传对象
    Integer update(ClassU classu);
    Integer delete(Integer id);
}
//记住班级实体类为ClassU
