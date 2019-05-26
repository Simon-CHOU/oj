package com.simon.oj.controller;

import com.simon.oj.common.Result;
import com.simon.oj.common.ResultCode;
import com.simon.oj.pojo.Student;
import com.simon.oj.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping(value = "/list")
    public Result getStudents(){
        return Result.success(studentService.findStudentList());
    }
    @GetMapping
    public Result getStudentById(@RequestParam(value = "id")String id){
        Result result = new Result();
        try{
            Student student = studentService.findStudentById(id);
            if(student!=null){
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(student);
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
    public Result addStudent(@RequestParam(value = "id") String id,
                             @RequestParam(value = "password")String password){//添加学生主要时学生注册，传对象还是用户名密码
        Result result = new Result();
        try {
            int t = studentService.add(id,password);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        //验证id存在
        List<Student> slist = studentService.findStudentList();
        int flag =0;
        for (Student si:slist
        ) {
            if(student.getIdstudent().equals(si.getIdstudent())){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_INSERT_NOT_FOUND);//要更新的数据不存在
        }

        Result result = new Result();
        try {
            int t = studentService.update(student);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
        }
        return result;
    }

    @DeleteMapping
    public Result deleteStudent(@RequestParam String id){
        //验证id存在
        List<Student> slist = studentService.findStudentList();
        int flag =0;
        for (Student si:slist
        ) {
            if(id.equals(si.getIdstudent())){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = studentService.delete(id);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }
}
