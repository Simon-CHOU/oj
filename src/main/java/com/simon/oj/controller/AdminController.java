package com.simon.oj.controller;

import com.simon.oj.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

//    @RequestMapping(value = "/psw")
//    public String getProblems(@RequestParam(value="id")String id ){
//        System.out.println(id);
//        return adminService.getAdminById(id).getPassword();
//    }

}
