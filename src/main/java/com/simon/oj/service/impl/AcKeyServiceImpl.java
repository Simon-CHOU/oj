package com.simon.oj.service.impl;

import com.simon.oj.dao.AcMapper;
import com.simon.oj.pojo.AcExample;
import com.simon.oj.pojo.AcKey;
import com.simon.oj.service.IAcKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcKeyServiceImpl implements IAcKeyService {
    @Autowired
    private AcMapper acMapper;

    @Override
    public List<AcKey> findAcKeyList() throws DataAccessException {
        return acMapper.selectByExample(new AcExample());
    }

    @Override
    public List<AcKey> findAcKeysByAid(Integer idAssignment) throws DataAccessException {
        AcExample acExample = new AcExample();
        AcExample.Criteria criteria = acExample.createCriteria();
        criteria.andIdassignmentEqualTo(idAssignment);
        return acMapper.selectByExample(acExample);
    }

    @Override
    public List<AcKey> findAcKeysByCid(Integer idclass) throws DataAccessException {
        AcExample acExample = new AcExample();
        AcExample.Criteria criteria = acExample.createCriteria();
        criteria.andIdclassEqualTo(idclass);
        return acMapper.selectByExample(acExample);
    }

    @Override
    public Long countNumOfAssignmentsByClassUId(Integer idclass) throws DataAccessException {
        AcExample acExample = new AcExample();
        AcExample.Criteria criteria = acExample.createCriteria();
        criteria.andIdclassEqualTo(idclass);
        return acMapper.countByExample(acExample);
    }

    @Override
    public Integer addSingle(AcKey acKey) throws DataAccessException {
        return acMapper.insert(acKey);
    }

    @Override
    public Integer addBatch(Integer idassignment, List<Integer> idClassList) throws DataAccessException {
        //批量的特点是，通常为同一个作业，不同的班级
        int t = 0;
        for (Integer ic : idClassList
        ) {
            AcKey tAcKey = new AcKey();
            tAcKey.setIdassignment(idassignment);
            tAcKey.setIdclass(ic);//创建并初始化对象
            t = acMapper.insert(tAcKey);//插入之
        }
        return t;
    }

//    @Override
//    public Integer updateSingle(AcKey acKey) throws DataAccessException {
//        AcExample acExample = new AcExample();
//        AcExample.Criteria criteria = acExample.createCriteria();
//        criteria.andIdassignmentEqualTo(acKey.getIdassignment());
//        criteria.andIdclassEqualTo(acKey.getIdclass());
//        return acMapper.updateByExample(acKey, acExample);//定位一条关系记录后，改变它，似乎没啥用
//    }

    @Override
    public Integer updateBatch(Integer idassignment, List<Integer> idClassList) throws DataAccessException {//同一个作业，不同班级
        //传过来的list是新的发布关系，需要先删除修的，再添加新的，而不是更改旧记录
        //比如作业1，原来分配给1，2，3班，现在要分配给1，2，4，5班，
        //并非是去update 作业1-3班这一条记录
        //方法1，判断新的分配关系较原来多了4,5，少了3班，就删3，添加4，5
        //方法2，删除所有的旧的，添加所有的新的（法2简单，用法2）
        //自注：这里传入的List<AcKey>本质上更像Map<K,V>
        AcExample acExample = new AcExample();
        AcExample.Criteria criteria = acExample.createCriteria();
        criteria.andIdassignmentEqualTo(idassignment);
        acMapper.deleteByExample(acExample);//delete  from ac where idassignment=x 删除旧的

        int t = 0;
        for (Integer ic : idClassList
        ) {
            AcKey tAcKey = new AcKey();
            tAcKey.setIdassignment(idassignment);
            tAcKey.setIdclass(ic);
            t = acMapper.insert(tAcKey);//插入新的，大功告成
        }
        return t;
    }

    @Override
    public Integer deleteSingle(AcKey acKey) throws DataAccessException {
        AcExample acExample = new AcExample();
        AcExample.Criteria criteria = acExample.createCriteria();
        criteria.andIdassignmentEqualTo(acKey.getIdassignment());
        criteria.andIdclassEqualTo(acKey.getIdclass());
        return acMapper.deleteByExample(acExample);
    }

    @Override
    public Integer deleteBatch(Integer idassignment) {
        AcExample acExample = new AcExample();
        AcExample.Criteria criteria = acExample.createCriteria();
        criteria.andIdassignmentEqualTo(idassignment);
        int t = acMapper.deleteByExample(acExample);
        return t;
    }
}
