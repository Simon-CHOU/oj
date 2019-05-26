package com.simon.oj.service.impl;

import com.simon.oj.dao.TeacherMapper;
import com.simon.oj.pojo.Teacher;
import com.simon.oj.pojo.TeacherExample;
import com.simon.oj.service.ITeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacher {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findTeacherList() {
        return teacherMapper.selectByExample(new TeacherExample());
    }

    @Override
    public Teacher findTeacherById(String id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer add(String id, String password) {
        Teacher teacher = new Teacher();
        teacher.setIdteacher(id);
        teacher.setPassword(password);
        teacher.setPermission(2);//固定值
        return teacherMapper.insert(teacher);
    }

    @Override
    public Integer update(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public Integer delete(String id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }
}
