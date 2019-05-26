package com.simon.oj.service;

import com.simon.oj.pojo.Admin;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAdminService {
    List<Admin> findAdminList();
    Admin findAdminById(String idAdmin);
    Integer update(String id,String password);
    Integer delete(String id);
    Integer add(String id, String password);
}
