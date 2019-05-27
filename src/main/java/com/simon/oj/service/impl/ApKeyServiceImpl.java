package com.simon.oj.service.impl;

import com.simon.oj.dao.ApMapper;
import com.simon.oj.pojo.ApExample;
import com.simon.oj.pojo.ApKey;
import com.simon.oj.service.IApKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApKeyServiceImpl implements IApKeyService {
    @Autowired
    private ApMapper apMapper;

    @Override
    public List<ApKey> findApKeyList() throws DataAccessException {
        return apMapper.selectByExample(new ApExample());
    }

    @Override
    public List<ApKey> findApKeysByAid(Integer idAssignment) throws DataAccessException {
        ApExample apExample = new ApExample();
        ApExample.Criteria criteria = apExample.createCriteria();
        criteria.andIdassignmentEqualTo(idAssignment);
        return apMapper.selectByExample(apExample);
    }

    @Override
    public List<ApKey> findApKeysByPid(Integer idproblem) throws DataAccessException {
        ApExample apExample = new ApExample();
        ApExample.Criteria criteria = apExample.createCriteria();
        criteria.andIdproblemEqualTo(idproblem);
        return apMapper.selectByExample(apExample);
    }

    @Override
    public Long countNumOfProblemsByAssignmentId(Integer idassignment) throws DataAccessException {
        ApExample apExample = new ApExample();
        ApExample.Criteria criteria = apExample.createCriteria();
        criteria.andIdassignmentEqualTo(idassignment);
        return apMapper.countByExample(apExample);
    }

    @Override
    public Integer addSingle(ApKey apKey) throws DataAccessException {
        return apMapper.insert(apKey);
    }

    @Override
    public Integer addBatch(Integer idassignment, List<Integer> idProblemList) throws DataAccessException {
        //批量的特点是，通常为同一个作业，不同的班级
        int t = 0;
        for (Integer ip : idProblemList
        ) {
            ApKey tApKey = new ApKey();
            tApKey.setIdassignment(idassignment);
            tApKey.setIdproblem(ip);//创建并初始化对象
            t = apMapper.insert(tApKey);//插入之
        }
        return t;
    }


    @Override
    public Integer updateBatch(Integer idassignment, List<Integer> idProblemList) throws DataAccessException {
        ApExample apExample = new ApExample();
        ApExample.Criteria criteria = apExample.createCriteria();
        criteria.andIdassignmentEqualTo(idassignment);
        apMapper.deleteByExample(apExample);//删除旧的

        int t = 0;
        for (Integer ip : idProblemList
        ) {
            ApKey tApKey = new ApKey();
            tApKey.setIdassignment(idassignment);
            tApKey.setIdproblem(ip);
            t = apMapper.insert(tApKey);//插入新的，大功告成
        }
        return t;
    }

    @Override
    public Integer deleteSingle(ApKey apKey) throws DataAccessException {
        ApExample apExample = new ApExample();
        ApExample.Criteria criteria = apExample.createCriteria();
        criteria.andIdassignmentEqualTo(apKey.getIdassignment());
        criteria.andIdproblemEqualTo(apKey.getIdproblem());
        return apMapper.deleteByExample(apExample);
    }

    @Override
    public Integer deleteBatch(Integer idassignment) {
        ApExample apExample = new ApExample();
        ApExample.Criteria criteria = apExample.createCriteria();
        criteria.andIdassignmentEqualTo(idassignment);
        int t = apMapper.deleteByExample(apExample);
        return t;
    }
}
