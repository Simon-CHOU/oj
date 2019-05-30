package com.simon.oj.controller;

import com.simon.oj.comm.Result;
import com.simon.oj.comm.ResultCode;
import com.simon.oj.pojo.Teacher;
import com.simon.oj.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping(value = "/list")
    public Result getTeachers(){
        return Result.success(teacherService.findTeacherList());
    }
    @GetMapping
    public Result getStudentById(@RequestParam(value = "id")String id){
        Result result = new Result();
        try{
            Teacher teacher = teacherService.findTeacherById(id);
            if(teacher!=null){
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(teacher);
            }else {
                result.setResultCode(ResultCode.RESULE_DATA_NONE);
            }
        }catch (Exception e){
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_RETRIEVE_WRONG);
        }
        return  result;
    }

    @PostMapping
    public Result addTeacher(@RequestParam(value = "id") String id,
                             @RequestParam(value = "password")String password){//以用户名密码添加教师
        Result result = new Result();
        try {
            int t = teacherService.add(id,password);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @PutMapping
    public Result updateTeacher(@RequestBody Teacher teacher){
        //验证id存在
        List<Teacher> tlist = teacherService.findTeacherList();
        int flag =0;
        for (Teacher ti:tlist
        ) {
            if(teacher.getIdteacher().equals(ti.getIdteacher())){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_INSERT_NOT_FOUND);//要更新的数据不存在
        }

        Result result = new Result();
        try {
            int t = teacherService.update(teacher);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
        }
        return result;
    }

    @DeleteMapping
    public Result deleteTeacher(@RequestParam String id){
        //验证id存在
        List<Teacher> tlist = teacherService.findTeacherList();
        int flag =0;
        for (Teacher ti:tlist
        ) {
            if(id.equals(ti.getIdteacher())){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = teacherService.delete(id);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }
}
