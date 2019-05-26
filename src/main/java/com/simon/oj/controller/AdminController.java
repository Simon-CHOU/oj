package com.simon.oj.controller;

import com.simon.oj.pojo.Admin;
import com.simon.oj.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    //    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping(value = "/list")
    public List<Admin> getAdmins() {
        return adminService.findAdminList();
    }

    @GetMapping
    public Admin getAdminById(@RequestParam("id") String id) {
        return adminService.findAdminById(id);
    }

    @PutMapping
    public String updateAdmin(@RequestParam("id") String id,
                              @RequestParam(value = "password", required = true) String password) {
        int t = adminService.update(id, password);//管理员是没有username的
        if (t != 0) {
            return "success";
        } else {
            return "fail";
        }

    }

    @DeleteMapping
    public String deleteAdmin(@RequestParam(value = "id") String id) {
        int t = adminService.delete(id);
        if (t != 0) {
            return "success";
        } else {
            return "fail";
        }

    }

    @PostMapping
    public String addAdmin(@RequestParam(value = "id") String id,
                           @RequestParam(value = "password") String password) {
        int t = 0;
        try {
            t = adminService.add(id, password);//permission admin:3,teacher:2,student:1，数据库默认值
        } catch (DataAccessException e) {
            System.out.println(e.toString());
        }
        if (t != 0) {
            return "success";
        } else {
            return "fail";
        }

    }
}
