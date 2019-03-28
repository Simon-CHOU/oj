package com.simon.oj.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import swust.yang.entity.ResultMsg;
import swust.yang.service.IPlug;
import swust.yang.service.impl.CpplintPlug;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

@RestController
@RequestMapping("/addPlugin")
public class PluginLayerGetter {
    private  IPlug iPlug;

    public PluginLayerGetter() {
        try {
            URL url1 = new URL("https://gitee.com/xingyongzhi/oj-plugins-base/raw/master/cpplint.jar");
            URLClassLoader myClassLoader1 = new URLClassLoader(new URL[]{url1}, Thread.currentThread()
                    .getContextClassLoader());
            Class<?> myClass1 = myClassLoader1.loadClass("swust.yang.service.impl.CpplintPlug");
            this.iPlug = (IPlug) myClass1.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/cpplinthtml", method = RequestMethod.GET)
    public String getCpplintHtml() {
        String str1 = iPlug.getHtml(null);//测试输出
        return str1;
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public String handConfigParam(@RequestBody String config_info) {
        System.out.println("提交字符串"+config_info);
        String file_path = "E:\\plugin-excute-workshop\\5120152516.cpp";
        String log_path = "E:\\plugin-excute-workshop\\log";
        ResultMsg msg = iPlug.singleExecute(config_info, file_path, log_path);
        System.out.println("学生信息：" + msg.getStudent_infor());
        System.out.println("本次得分：" + msg.getScore());
        return JSON.toJSONString(msg);
    }
}
