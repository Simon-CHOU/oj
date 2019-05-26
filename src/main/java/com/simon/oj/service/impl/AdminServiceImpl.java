package com.simon.oj.service.impl;


import com.simon.oj.dao.AdminMapper;
import com.simon.oj.pojo.Admin;
import com.simon.oj.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAdminList(){return adminMapper.selectAll();};

    @Override
    public Admin findAdminById(String idAdmin){
        return adminMapper.selectByPrimaryKey(idAdmin);
    }

    @Override
    public Integer update(String id, String password) {
        Admin temp = new Admin();
        temp.setIdadmin(id);
        temp.setPassword(password);
        temp.setPermission(3);//admin的permission固定是3
        // 注意每一个字段都要赋值，否则会报错。
        return adminMapper.updateByPrimaryKey(temp);
    }

    @Override
    public Integer delete(String id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer add(String id, String password)throws DataAccessException {
        Admin temp = new Admin();
        temp.setIdadmin(id);
        temp.setPassword(password);
        temp.setPermission(3);
        return adminMapper.insert(temp);//处理用户名重复的异常
    }
}
