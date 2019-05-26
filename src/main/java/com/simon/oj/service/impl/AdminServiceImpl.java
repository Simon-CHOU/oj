package com.simon.oj.service.impl;


import com.simon.oj.dao.AdminMapper;
import com.simon.oj.pojo.Admin;
import com.simon.oj.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin getAdminById(String idAdmin){
        return adminMapper.selectByPrimaryKey(idAdmin);
    }

}
