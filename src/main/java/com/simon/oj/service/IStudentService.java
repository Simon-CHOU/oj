package com.simon.oj.service;

import com.simon.oj.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    List<Student> findStudentList();
    Student findStudentById(String id);
    Integer add(String id, String password);//添加学生是注册的，传对象反倒冗余了
    Integer update(Student student);
    Integer delete(String id);

}
