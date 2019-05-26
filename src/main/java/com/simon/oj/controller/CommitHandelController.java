package com.simon.oj.controller;

import com.alibaba.fastjson.JSON;
import com.simon.oj.pojo.CodeCommit;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swust.yang.entity.ResultMsg;
import swust.yang.service.IPlug;


import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

@RestController
@RequestMapping("/handelCommit")
public class CommitHandelController {
    private IPlug iPlug;

    public CommitHandelController() {
        try {
            URL url1 = new URL("https://gitee.com/xingyongzhi/oj-plugins-base/raw/master/cpplint-plug-1.2.jar");
            URLClassLoader myClassLoader1 = new URLClassLoader(new URL[]{url1}, Thread.currentThread()
                    .getContextClassLoader());
            Class<?> myClass1 = myClassLoader1.loadClass("swust.yang.service.impl.CpplintPlug");
            this.iPlug = (IPlug) myClass1.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/basicCheck")
    public String BasicCheck(@RequestBody CodeCommit codeCommit){

        //读取配置文件
        File file=new File("plugin-excute-workshop/lint-config-info.json");
        String config_str = null;//配置文件JSON字符串
        try {
            config_str= FileUtils.readFileToString(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("配置文件JSON字符串："+config_str);
//        读取配置文件完毕

//        根据配置文件执行检查
        String file_path = "plugin-excute-workshop\\5120152516.cpp";
        String log_path = "plugin-excute-workshop\\log";
        ResultMsg msg = new ResultMsg();
//        try {
//           msg =  iPlug.singleExecute(config_str,file_path,log_path);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (FileNotDirectoryException e) {
//            e.printStackTrace();
//        } catch (FileNotCOrCppExcption fileNotCOrCppExcption) {
//            fileNotCOrCppExcption.printStackTrace();
//        }
        msg.setStudentInfor("5120152525");
        msg.setScore(100f);

        System.out.println("检查结果："+msg.getStudentInfor()+","+msg.getScore());
        return JSON.toJSONString(msg);//返回单文件检查结果
    }


}
