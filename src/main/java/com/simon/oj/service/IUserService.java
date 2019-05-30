package com.simon.oj.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 因为数据库学生，教师，管理员数据库分别存在三张表里
 * 所以需要一个类将三者统一，Shrio登陆时方便验证
 */
@Service
public interface IUserService {
    /**
     * 获得密码
     * @param username 用户名
     */
    String getPassword(String username);

    /**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
    String getRole(String username);

    /**
     * 修改密码
     */
    void updatePassword(String username,  String newPassword);

    /**
     * 获得存在的用户
     */
    List<String> getUser();

    /**
     * 封号
     */
    void banUser(String username);

    /**
     * 检查用户状态
     */
    int checkUserBanStatus(String username);

    /**
     * 获得用户角色默认的权限
     */
    String getRolePermission(String username);

    /**
     * 获得用户的权限
     */
    String getPermission(String username);

    /**
     * 根据账户名查找用户姓名，管理员没有姓名，所以管理员的姓名就是账户名
     * @param username 账户名称
     * @return
     */
    String getName(String username);

    /**
     * 判断用户名是否重复，如果重复返回true     *
    * @param username
     * @return
     */
    Boolean isUsernameDuplicate(String username); // 学生注册、教师新增时用来保证三种角色的用户名各不相同
    //因为注册时，认为三种角色都是User，id是不同的，
    //学生、教师管理员三张表验证到一个id，就算登录

}
