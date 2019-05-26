package com.simon.oj.dao;

import com.simon.oj.pojo.Admin;
import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(String idadmin);

    int insert(Admin record);

    Admin selectByPrimaryKey(String idadmin);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}