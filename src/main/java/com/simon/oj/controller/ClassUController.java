package com.simon.oj.controller;
import com.simon.oj.comm.Result;
import com.simon.oj.comm.ResultCode;
import com.simon.oj.pojo.ClassU;
import com.simon.oj.service.impl.ClassUServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")//简单起见，url就叫class（Java所有地方班级都称为classu，除了pojo的getter,setter），
public class ClassUController {
    @Autowired
    private ClassUServiceImpl classUService;

    @GetMapping(value = "/list")
    public Result getClassUs() {
        return Result.success(classUService.findClassUList());
    }

    @GetMapping
    public Result getClassUById(@RequestParam(value = "id") Integer id) {
        Result result = new Result();
        try {
            ClassU t = classUService.findClassUById(id);
            if (t != null) {
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(t);
            } else {
                result.setResultCode(ResultCode.RESULE_DATA_NONE);//没找到不算异常，但是要提醒，这个分支时必要的
            }
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_RETRIEVE_WRONG);
        }
        return result;
    }

    @DeleteMapping
    public Result deleteClassU(@RequestParam(value = "id") Integer id) {
        //验证id存在
        List<ClassU> clist = classUService.findClassUList();
        int flag =0;
        for (ClassU ci:clist
        ) {
            if(id==ci.getIdclass()){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = classUService.delete(id);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }

    @PostMapping
    public Result addClassU(@RequestBody ClassU classU) {
        Result result = new Result();
        try {
            int t = classUService.add(classU);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @PutMapping
    public Result updateClassU(@RequestBody ClassU classU) {
        //验证id存在
        List<ClassU> clist = classUService.findClassUList();
        int flag =0;
        for (ClassU ci:clist
        ) {
            if(classU.getIdclass()==ci.getIdclass()){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_INSERT_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = classUService.update(classU);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
        }
        return result;
    }
}
