package com.simon.oj.service.impl;

import com.simon.oj.dao.StudentMapper;
import com.simon.oj.pojo.Student;
import com.simon.oj.pojo.StudentExample;
import com.simon.oj.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findStudentList() throws DataAccessException {
        return studentMapper.selectByExample(new StudentExample());
    }

    @Override
    public Student findStudentById(String id) throws DataAccessException{
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer add(String id, String password) throws DataAccessException{
        Student student = new Student();
        student.setIdstudent(id);
        student.setPassword(password);
        student.setPermission(1);//固定值
        return studentMapper.insert(student);
    }

    @Override
    public Integer update(Student student) throws DataAccessException{
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public Integer delete(String id) throws DataAccessException{
        return studentMapper.deleteByPrimaryKey(id);
    }
}
