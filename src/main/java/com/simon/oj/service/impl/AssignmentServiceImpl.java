package com.simon.oj.service.impl;

import com.simon.oj.dao.AssignmentMapper;
import com.simon.oj.pojo.Assignment;
import com.simon.oj.pojo.AssignmentExample;
import com.simon.oj.service.IAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImpl implements IAssignmentService {
    @Autowired
    private AssignmentMapper assignmentMapper;

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
}
