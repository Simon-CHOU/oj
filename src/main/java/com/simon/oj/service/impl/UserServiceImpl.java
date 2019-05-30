package com.simon.oj.service.impl;

import com.simon.oj.dao.AdminMapper;
import com.simon.oj.dao.StudentMapper;
import com.simon.oj.dao.TeacherMapper;
import com.simon.oj.pojo.Admin;
import com.simon.oj.pojo.Student;
import com.simon.oj.pojo.Teacher;
import com.simon.oj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public String getPassword(String username) {
        Student student = studentMapper.selectByPrimaryKey(username);
        Teacher teacher = teacherMapper.selectByPrimaryKey(username);
        Admin admin = adminMapper.selectByPrimaryKey(username);
        String password = null;
        //系统预定的学生和教师的账户名为学号和工号，理论上不会重复
        //管理员账户不用学号和工号，所以理论上都不会重复
        if (student != null) {
            password = student.getPassword();
        } else if (teacher != null) {
            password = teacher.getPassword();
        } else if (admin != null) {
            password = admin.getPassword();
        } else {
            System.out.println("账户不存在");
        }
        return password;
    }

    @Override
    public String getRole(String username) {
        Student student = studentMapper.selectByPrimaryKey(username);
        Teacher teacher = teacherMapper.selectByPrimaryKey(username);
        Admin admin = adminMapper.selectByPrimaryKey(username);
        String role = null;
        //因为三张表分开，学生教师管理员权限id固定为1，2，3，对应角色也为student,teacher,admin
        //没有角色内分配不同权限的需求
        if (student != null) {
            role = "student";
        } else if (teacher != null) {
            role = "teacher";
        } else if (admin != null) {
            role = "admin";
        } else {
            System.out.println("账户不存在");
        }
        return role;
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        //暂时不统一更新密码
    }

    @Override
    public List<String> getUser() {
        //暂不返回所有用户
        return null;
    }

    @Override
    public void banUser(String username) {
        //暂不统一停用账户
    }

    @Override
    public int checkUserBanStatus(String username) {
        return 0;//暂不检查账户停用状态
    }

    @Override
    public String getRolePermission(String username) {
        Student student = studentMapper.selectByPrimaryKey(username);
        Teacher teacher = teacherMapper.selectByPrimaryKey(username);
        Admin admin = adminMapper.selectByPrimaryKey(username);
        String role = null;
        //因为三张表分开，学生教师管理员权限id固定为1，2，3，对应角色也为student,teacher,admin
        //没有角色内分配不同权限的需求
        if (student != null) {
            role = "student";
        } else if (teacher != null) {
            role = "teacher";
        } else if (admin != null) {
            role = "admin";
        } else {
            System.out.println("账户不存在");
        }
        return role;
        //demo中,role表有role,permission，user表中也有role，permission
//        SELECT role.permission
//        FROM test.user, test.role
//        WHERE username = 'howie' AND role.role = user.role
    }

    @Override
    public String getPermission(String username) {
        Student student = studentMapper.selectByPrimaryKey(username);
        Teacher teacher = teacherMapper.selectByPrimaryKey(username);
        Admin admin = adminMapper.selectByPrimaryKey(username);
        String permission = null;
        //因为三张表分开，学生教师管理员权限id固定为1，2，3，对应角色也为student,teacher,admin
        //没有角色内分配不同权限的需求
        //role和permission 索性一一对应
        if (student != null) {
            permission = "student";
        } else if (teacher != null) {
            permission = "teacher";
        } else if (admin != null) {
            permission = "admin";
        } else {
            System.out.println("账户不存在");
        }
        return permission;
    }

    @Override
    public String getName(String username) {
        String name = username;//教师或学生的姓名，管理员的账户名
        Student student = studentMapper.selectByPrimaryKey(username);
        Teacher teacher = teacherMapper.selectByPrimaryKey(username);
        if (student != null && student.getName() != null) {//有这个学生账户且这个学生账户有姓名
            name = student.getName();
        } else if (teacher != null && teacher.getName() != null) {////有这个学生账户且这个学生账户有姓名
            name = teacher.getName();
        } else {
            System.out.println("账户不存在");
        }
        return name;//如果学生和教师有账户但是尚未设置姓名，则返回账户ID名
    }

    @Override
    public Boolean isUsernameDuplicate(String username) {
        Boolean flag = true;
        Student student = studentMapper.selectByPrimaryKey(username);
        Teacher teacher = teacherMapper.selectByPrimaryKey(username);
        Admin admin = adminMapper.selectByPrimaryKey(username);
        if (student == null && teacher == null && admin == null) {
            flag = false;
        }
        return flag;
    }
}
