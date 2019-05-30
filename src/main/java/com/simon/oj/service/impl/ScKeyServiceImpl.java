package com.simon.oj.service.impl;

import com.simon.oj.dao.ScMapper;
import com.simon.oj.pojo.ScExample;
import com.simon.oj.pojo.ScKey;
import com.simon.oj.service.IScKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScKeyServiceImpl implements IScKeyService {
    @Autowired
    private ScMapper scMapper;

    @Override
    public List<ScKey> findScKeyList() throws DataAccessException {
        return scMapper.selectByExample(new ScExample());
    }

    @Override
    public List<ScKey> findScKeysBySid(String idstudent) throws DataAccessException{
        ScExample scExample = new ScExample();
        ScExample.Criteria criteria = scExample.createCriteria();
        criteria.andIdstudentEqualTo(idstudent);
        return scMapper.selectByExample(scExample);
    }

    @Override
    public List<ScKey> findScKeysByCid(Integer idclass) throws DataAccessException{
        ScExample scExample = new ScExample();
        ScExample.Criteria criteria = scExample.createCriteria();
        criteria.andIdclassEqualTo(idclass);
        return scMapper.selectByExample(scExample);
    }

    @Override
    public Long countNumOfStudentsByClassUId(Integer idclass) throws DataAccessException{
        ScExample scExample = new ScExample();
        ScExample.Criteria criteria = scExample.createCriteria();
        criteria.andIdclassEqualTo(idclass);
        return  scMapper.countByExample(scExample);
    }

    @Override
    public Integer add(ScKey scKey) throws DataAccessException{
        return scMapper.insert(scKey);
    }

//    @Override
//    public Integer update(ScKey scKey) {
//        return 0;//没什么用
//    }

    @Override
    public Integer delete(ScKey scKey) throws DataAccessException{
        ScExample scExample = new ScExample();
        ScExample.Criteria criteria = scExample.createCriteria();
        criteria.andIdclassEqualTo(scKey.getIdclass());
        criteria.andIdstudentEqualTo(scKey.getIdstudent());
        return scMapper.deleteByExample(scExample);
    }
}
