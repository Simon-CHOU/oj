package com.simon.oj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.simon.oj.comm.Result;
import com.simon.oj.comm.ResultCode;
import com.simon.oj.dto.UsernamePasswordPairDto;
import com.simon.oj.service.impl.StudentServiceImpl;
import com.simon.oj.service.impl.UserServiceImpl;
import com.simon.oj.util.JWTUtil;
import com.simon.oj.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-04-29
 * @Time 13:20
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private StudentServiceImpl studentService;
//    private final ResultMap resultMap;

//    @Autowired
//    public LoginController(UserServiceImpl userService, ResultMap resultMap) {
//        this.userService = userService;
//        this.resultMap = resultMap;
//    }

    @PostMapping("/login")
    public Result login(@RequestBody String UsernamePasswordPair) {
        UsernamePasswordPairDto userLogInfo = JSON.parseObject(UsernamePasswordPair, UsernamePasswordPairDto.class);
        String password = userLogInfo.getPassword();
        String username = userLogInfo.getUsername();
        //@RequestParam("username") String username,
        //                           @RequestParam("password") String password
        String realPassword = userService.getPassword(username);
        if (realPassword == null) {
//            return resultMap.fail().code(401).message("用户名错误");
            return Result.failure(ResultCode.USER_NOT_EXIST);
        } else if (!realPassword.equals(password)) {
//            return resultMap.fail().code(401).message("密码错误");
            return Result.failure(ResultCode.USER_LOGIN_ERROR);
        } else {
//            return resultMap.success().code(200).message(JWTUtil.createToken(username));
            String token = JWTUtil.createToken(username);//这里的username 是账户名，是id不是姓名
            return Result.success(token);//发送Token
        }
    }

//    @RequestMapping(path = "/unauthorized/{message}")
//    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
//        return resultMap.success().code(401).message(message);
//    }

    @PostMapping(value = "/user/info")
    public Result getUserInfo(@RequestParam(value = "token") String token) {
        String username = JWTUtil.getUsername(token);//从Token中分离用户名
        //根据用户名查到role
        List<String> roles = new ArrayList<>();
        roles.add("editor");
        UserInfoVo userInfoVo = new UserInfoVo();
        //设置角色
        userInfoVo.setRoles(roles);
        //设置姓名
        userInfoVo.setName(userService.getName(username));
        //设置头像，暂时统一
        userInfoVo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        //设置介绍，暂时统一
        userInfoVo.setIntroduction("一位用户");
        //设置token
        userInfoVo.setToken(token);


        Object json = JSONObject.toJSON(userInfoVo);
        System.out.println(json);
        return Result.success(json);
    }

    @PostMapping(value = "/logout")
    public Result logOut() {
        return Result.success();
    }

    // 学生注册，本质上和 StudentConotroller 中的 Add 方法是一样的
    @PostMapping("/register")
    public Result registerStu(@RequestBody String UsernamePasswordPair) {
        UsernamePasswordPairDto userLogInfo = JSON.parseObject(UsernamePasswordPair, UsernamePasswordPairDto.class);
        String password = userLogInfo.getPassword();
        String username = userLogInfo.getUsername();
        Result result = new Result();
        //先验证要注册的学生用户名没有与教师和管理员重复
        if (!userService.isUsernameDuplicate(username)) {
            try {
                int t = studentService.add(username, password);
                result.setResultCode(ResultCode.SUCCESS);
            } catch (Exception e) {
                System.out.println(e);
                result.setResultCode(ResultCode.DATA_INSERT_WRONG);
            }
        }else{
            result.setResultCode(ResultCode.USER_HAS_EXISTED);
        }
        return result;
    }
}
