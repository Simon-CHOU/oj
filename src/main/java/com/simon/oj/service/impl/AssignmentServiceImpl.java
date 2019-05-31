package com.simon.oj.service.impl;

import com.simon.oj.dao.AssignmentMapper;
import com.simon.oj.dao.TeacherMapper;
import com.simon.oj.pojo.Assignment;
import com.simon.oj.pojo.AssignmentExample;
import com.simon.oj.service.IAssignmentService;
import com.simon.oj.vo.AssignmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentServiceImpl implements IAssignmentService {
    @Autowired
    private AssignmentMapper assignmentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Assignment findAssignmentById(Integer id)  throws DataAccessException {
        return assignmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Assignment> findAssignmentList()  throws DataAccessException{
        return assignmentMapper.selectByExample(new AssignmentExample());
    }

    @Override
    public Integer add(Assignment assignment)  throws DataAccessException{
        return assignmentMapper.insert(assignment);
    }

    @Override
    public Integer update(Assignment assignment)  throws DataAccessException{
        return assignmentMapper.updateByPrimaryKey(assignment);
    }

    @Override
    public Integer delete(Integer id)  throws DataAccessException{
        return assignmentMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<AssignmentVo> findAssignmentVoList() throws DataAccessException {
        List<Assignment> alist = assignmentMapper.selectByExample(new AssignmentExample());
        List<AssignmentVo> avolist = new ArrayList<>();
        for (Assignment ia:alist
             ) {
            AssignmentVo temp = new AssignmentVo();
            temp.setIdassignment(ia.getIdassignment());//id
            temp.setTitle(ia.getTitle());//标题
            String idteacher = ia.getIdteacher();
            String teacherName =   teacherMapper.selectByPrimaryKey(idteacher).getName();
            temp.setTeacherName(teacherName);//出题老师
            temp.setCommence(ia.getCommence());//开始日期
            temp.setDeadline(ia.getDeadline());//结束日期
            temp.setStatus(ia.getStatus());//当前状态
            avolist.add(temp);
        }
        return avolist;
    }
}
