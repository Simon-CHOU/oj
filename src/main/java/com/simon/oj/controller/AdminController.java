package com.simon.oj.controller;

import com.simon.oj.common.Result;
import com.simon.oj.common.ResultCode;
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
    public Result getAdmins() {
        return Result.success(adminService.findAdminList());
    }

    @GetMapping
    public Result getAdminById(@RequestParam("id") String id) {
        Admin admin = adminService.findAdminById(id);
        if(admin!=null){
            return Result.success(admin);
        }else {
            return Result.failure(ResultCode.RESULE_DATA_NONE);
        }

    }

    @PutMapping
    public Result updateAdmin(@RequestParam("id") String id,
                              @RequestParam(value = "password", required = true) String password) {
        int t = adminService.update(id, password);//管理员是没有username的
        if (t != 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.DATA_UPDATE_WRONG);
        }

    }

    @DeleteMapping
    public Result deleteAdmin(@RequestParam(value = "id") String id) {
        int t = adminService.delete(id);
        if (t != 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.DATA_DELETE_WRONG);
        }

    }

    @PostMapping
    public Result addAdmin(@RequestParam(value = "id") String id,
                           @RequestParam(value = "password") String password) {
        int t = 0;
        try {
            t = adminService.add(id, password);//permission admin:3,teacher:2,student:1，数据库默认值
        } catch (DataAccessException e) {
            System.out.println(e.toString());
        }
        if (t != 0) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.DATA_INSERT_WRONG);
        }

    }
}
