package com.simon.oj.service.impl;

import com.simon.oj.dao.TeacherMapper;
import com.simon.oj.pojo.Teacher;
import com.simon.oj.pojo.TeacherExample;
import com.simon.oj.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findTeacherList() throws DataAccessException {
        return teacherMapper.selectByExample(new TeacherExample());
    }

    @Override
    public Teacher findTeacherById(String id) throws DataAccessException {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer add(String id, String password) throws DataAccessException {
        Teacher teacher = new Teacher();
        teacher.setIdteacher(id);
        teacher.setPassword(password);
        teacher.setPermission(2);//固定值
        return teacherMapper.insert(teacher);
    }

    @Override
    public Integer update(Teacher teacher) throws DataAccessException {
        return teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public Integer delete(String id) throws DataAccessException {
        return teacherMapper.deleteByPrimaryKey(id);
    }
}
