package com.simon.oj.service;


import com.simon.oj.pojo.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITeacherService {
    List<Teacher> findTeacherList();
    Teacher findTeacherById(String id);
    Integer add(String id, String password);//管理员添加教师也是从简，不传对象
    Integer update(Teacher teacher);
    Integer delete(String id);
}
