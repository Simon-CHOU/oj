package com.simon.oj.service;

import com.simon.oj.pojo.Admin;
import org.springframework.stereotype.Service;

@Service
public interface IAdminService {
//    List<Admin> getAllAdmin();
Admin getAdminById(String idAdmin);
}
