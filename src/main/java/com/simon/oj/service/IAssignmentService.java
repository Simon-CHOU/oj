package com.simon.oj.service;

import com.simon.oj.pojo.Assignment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAssignmentService {
    Assignment findAssignmentById(Integer id);
    List<Assignment> findAssignmentList();
    Integer add(Assignment assignment);//字段太多所以传对象
    Integer update(Assignment assignment);
    Integer delete(Integer id);
}
