package com.simon.oj.controller;

import org.springframework.web.bind.annotation.*;
import swust.yang.service.IPlug;
//import swust.yang.service.impl.CpplintPlug;


@RestController
@RequestMapping("/addPlugin")
public class PluginLayerGetter {
    private  IPlug iPlug;

//    public PluginLayerGetter() {
//        try {
////            URL url1 = new URL("https://gitee.com/xingyongzhi/oj-plugins-base/raw/master/cpplint.jar");
////            URL url1 = new URL("file:\\D:\\cpplint-plug-1.2.jar");
//            URL url1 = new URL("https://gitee.com/xingyongzhi/oj-plugins-base/raw/master/cpplint-plug-1.2.jar");
//            URLClassLoader myClassLoader1 = new URLClassLoader(new URL[]{url1}, Thread.currentThread()
//                    .getContextClassLoader());
//            Class<?> myClass1 = myClassLoader1.loadClass("swust.yang.service.impl.CpplintPlug");
//            this.iPlug = (IPlug) myClass1.getConstructor().newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping(value = "/cpplinthtml", method = RequestMethod.GET)
//    public String getCpplintHtml() {
//        String str1 = iPlug.getHtml(null);//测试输出
//        return str1;
//    }
//
//    @RequestMapping(value = "/action", method = RequestMethod.POST)
//    public String handConfigParam(String config_info) {
//        System.out.println("提交字符串"+config_info);
//        System.out.println("配置表单检查结果："+iPlug.checkConfigInfo(config_info));
//        String file_path = "plugin-excute-workshop\\5120152516.cpp";
//        String log_path = "plugin-excute-workshop\\log";
//        ResultMsg msg = null;
//        try {
//            msg = iPlug.singleExecute(config_info, file_path, log_path);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (FileNotDirectoryException e) {
//            e.printStackTrace();
//        } catch (FileNotCOrCppExcption fileNotCOrCppExcption) {
//            fileNotCOrCppExcption.printStackTrace();
//        }
//        System.out.println("学生信息：" + msg.getStudentInfor());
//        System.out.println("本次得分：" + msg.getScore());
//        return JSON.toJSONString(msg);
//    }
}
