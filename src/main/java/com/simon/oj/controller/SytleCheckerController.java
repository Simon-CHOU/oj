package com.simon.oj.controller;

import com.simon.oj.comm.Result;
import org.springframework.web.bind.annotation.*;
import swust.yang.entity.ResultMsg;
import swust.yang.service.IPlug;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

@RestController
@RequestMapping("/check")
public class SytleCheckerController {
    @PostMapping(value = "/style")
    public Result CheckStyle (@RequestBody String configInfo){
        IPlug iPlug = null;
        try {
            URL url = new URL("file:./plugins/style-checker/cpplint-1.0.5.jar");
            URLClassLoader myClassLoader = new URLClassLoader(new URL[] { url },
                    Thread.currentThread().getContextClassLoader());
            Class<?> myClass = myClassLoader.loadClass("swust.yang.service.impl.CpplintPlug");
            iPlug = (IPlug) myClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        String configInfo ="{\"totalScore\":\"100\",\"checkFuncAnnotation\":\"~RULE_5_3_A_provide_doxygen_function_comment_on_function_in_impl\",\"scoreOfFuncAnnotation\":\"10\",\"checkFuncName\":\"~RULE_3_3_A_start_function_name_with_lowercase_unix\",\"scoreOfFuncName\":\"10\",\"checkFuncParamtersNum\":\"~RULE_6_1_E_do_not_use_more_than_5_paramters_in_function\",\"scoreOfFuncParamtersNum\":\"10\",\"checkFuncStatLinesNum\":\"~RULE_6_1_G_write_less_than_200_lines_for_function\",\"scoreOfFuncStatLinesNum\":\"10\",\"checkMacroName\":\"~RULE_6_5_B_do_not_use_lowercase_for_macro_constants\",\"scoreOfMacroName\":\"10\",\"checkNestedNum\":\"~RULE_A_3_avoid_too_deep_block\",\"scoreOfNestedNum\":\"10\",\"checkUseGoto\":\"~RULE_7_2_B_do_not_use_goto_statement\",\"scoreOfUseGoto\":\"10\",\"checkLineLength\":\"~RULE_4_4_A_do_not_write_over_120_columns_per_line\",\"scoreOfLineLength\":\"10\",\"checkIdentationStyle\":\"\",\"scoreOfIdentationStyle\":\"\",\"checkWordSpace\":\"~RULE_4_2_A_B_space_around_word\",\"scoreOfWordSpace\":\"10\",\"checkKeyWordsUseBraces\":\"~RULE_4_5_B_use_braces_even_for_one_statement\",\"scoreOfKeyWordsUseBraces\":\"5\",\"scoreOfExtendRules\":\"5\",\"checkExtendRules\":\"~RULE_3_3_A_start_function_name_with_is_or_has_when_return_bool;\"}";
        System.out.println(iPlug.checkConfigInfo(configInfo));
        String tooldir = "D:\\Development\\IdeaProjects\\oj\\plugins\\style-checker\\nsiqcppstyle";
        String filePath ="D:\\Development\\IdeaProjects\\oj\\plugins\\style-checker\\style-checker-testcases\\fibonacci.cpp";
        String logDir="D:\\Development\\IdeaProjects\\oj\\plugins\\style-checker\\style-checker-testcases\\log";
        ResultMsg msg = iPlug.singleExecute(configInfo,tooldir,filePath,logDir);
        System.out.println(msg.getMessage());
        System.out.println(msg.getCode());
        System.out.println(msg.getStudentInfo());
        System.out.println(msg.getValue());
        return  Result.success(msg);

//		iPlug.singleExecute(configInfo, toolPath, filePath, logDir)
//		String config =
//		System.out.println(iPlug.getHtml(null));

//
//		String config ="{\"totalScore\":\"100\",\"scoreOfError\":\"100\",\"checkWarning\":\"\",\"scoreOfWarning\":\"\",\"checkStyle\":\"\",\"scoreOfStyle\":\"\",\"checkPortability\":\"\",\"scoreOfPortability\":\"\",\"checkPerformance\":\"\",\"scoreOfPerformance\":\"\"}";
//		ResultMsg msg = iPlug.singleExecute(config, toolPath, filePath, logDir);

//		iPlug.batchExecute(configInfo, toolPath, srcDir, logDir)
    }

    @PostMapping(value = "/style/batch")
    public Result CheckStyleBatch (@RequestBody String configInfo){
        IPlug iPlug = null;
        try {
            URL url = new URL("file:./plugins/style-checker/cpplint-1.0.5.jar");
            URLClassLoader myClassLoader = new URLClassLoader(new URL[] { url },
                    Thread.currentThread().getContextClassLoader());
            Class<?> myClass = myClassLoader.loadClass("swust.yang.service.impl.CpplintPlug");
            iPlug = (IPlug) myClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(iPlug.checkConfigInfo(configInfo));
        String toolPath = "D:\\Development\\IdeaProjects\\oj\\plugins\\style-checker\\nsiqcppstyle";
        String srcDir ="D:\\Development\\IdeaProjects\\oj\\plugins\\style-checker\\style-checker-testcases";
        String logDir="D:\\Development\\IdeaProjects\\oj\\plugins\\style-checker\\style-checker-testcases\\log";
        List<ResultMsg> msglist = iPlug.batchExecute(configInfo, toolPath, srcDir, logDir);
        return  Result.success(msglist);
    }


    @PostMapping(value = "/static")
    public Result CheckStatic (@RequestBody String configInfo){
        IPlug iPlug = null;
        try {
            URL url = new URL("file:./plugins/static-checker/cppcheck-1.0.4.jar");
            URLClassLoader myClassLoader = new URLClassLoader(new URL[] { url },
                    Thread.currentThread().getContextClassLoader());
            Class<?> myClass = myClassLoader.loadClass("swust.yang.service.impl.CppcheckPlug");
            iPlug = (IPlug) myClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String s = iPlug.checkConfigInfo(configInfo);
        System.out.println(s);
        String tooldir = "D:\\Cppcheck";
        String filePath ="D:\\Development\\IdeaProjects\\oj\\plugins\\style-checker\\style-checker-testcases\\fibonacci.cpp";
        String logDir="D:\\Development\\IdeaProjects\\oj\\plugins\\static-checker\\static-checker-testcases\\log";
        ResultMsg msg = iPlug.singleExecute(configInfo,tooldir,filePath,logDir);
        System.out.println(msg.getMessage());
        System.out.println(msg.getCode());
        System.out.println(msg.getStudentInfo());
        System.out.println(msg.getValue());

        return  Result.success(msg);
    }
    @PostMapping(value = "/static/batch")
    public Result CheckStaticBatch (@RequestBody String configInfo){
        IPlug iPlug = null;
        try {
            URL url = new URL("file:./plugins/static-checker/cppcheck-1.0.4.jar");
            URLClassLoader myClassLoader = new URLClassLoader(new URL[] { url },
                    Thread.currentThread().getContextClassLoader());
            Class<?> myClass = myClassLoader.loadClass("swust.yang.service.impl.CppcheckPlug");
            iPlug = (IPlug) myClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String s = iPlug.checkConfigInfo(configInfo);
        System.out.println(s);
        String toolPath = "D:\\Cppcheck";
        String srcDir ="D:\\Development\\IdeaProjects\\oj\\plugins\\static-checker\\static-checker-testcases";
        String logDir="D:\\Development\\IdeaProjects\\oj\\plugins\\static-checker\\static-checker-testcases\\log";
        List<ResultMsg> msg = iPlug.batchExecute(configInfo, toolPath, srcDir, logDir);

        return  Result.success(msg);
    }

    @PostMapping(value = "/redundant")
    public Result CheckRedundant (@RequestBody String configInfo){
        IPlug iPlug = null;
        try {
            URL url = new URL("file:./plugins/duplicat-checker/codeRecheck-1.0.1.jar");
            URLClassLoader myClassLoader = new URLClassLoader(new URL[] { url },
                    Thread.currentThread().getContextClassLoader());
            Class<?> myClass = myClassLoader.loadClass("swust.yang.service.impl.CodeRecheckPlug");
            iPlug = (IPlug) myClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String s = iPlug.checkConfigInfo(configInfo);
        System.out.println(s);
        String tooldir = "D:\\Development\\IdeaProjects\\oj\\plugins\\duplicat-checker\\sim_exe_3_0_2";
        String fileDir ="D:\\Development\\IdeaProjects\\oj\\plugins\\duplicat-checker\\duplicat-checker-testcases";
        String logDir="D:\\Development\\IdeaProjects\\oj\\plugins\\duplicat-checker\\duplicat-checker-testcases\\log";
        List<ResultMsg> msglist = iPlug.batchExecute(configInfo,tooldir,fileDir,logDir);
        return  Result.success(msglist);
    }
}
