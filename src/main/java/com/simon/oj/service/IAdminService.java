package com.simon.oj.service;

import com.simon.oj.dao.AdminMapper;
import com.simon.oj.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAdminService {
//    List<Admin> getAllAdmin();
Admin getAdminById(String idAdmin);
}
