package com.simon.oj.controller;

import com.simon.oj.common.Result;
import com.simon.oj.common.ResultCode;
import com.simon.oj.pojo.Assignment;
import com.simon.oj.service.impl.AssignmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    private AssignmentServiceImpl assignmentService;

    @GetMapping(value = "/list")
    public Result getAssignments() {
        return Result.success(assignmentService.findAssignmentList());
    }

    @GetMapping
    public Result getAssignmentById(@RequestParam(value = "id") Integer id) {
        Result result = new Result();
        try {
            Assignment t = assignmentService.findAssignmentById(id);
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
    public Result deleteAssignment(@RequestParam(value = "id") Integer id) {
        //验证id存在
        List<Assignment> alist = assignmentService.findAssignmentList();
        int flag =0;
        for (Assignment ai:alist
        ) {
            if(id==ai.getIdassignment()){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = assignmentService.delete(id);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }

    @PostMapping
    public Result addAssignment(@RequestBody Assignment assignment) {
        Result result = new Result();
        try {
            int t = assignmentService.add(assignment);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @PutMapping
    public Result updateAssignment(@RequestBody Assignment assignment) {
        //验证id存在
        List<Assignment> alist = assignmentService.findAssignmentList();
        int flag =0;
        for (Assignment ai:alist
        ) {
            if(assignment.getIdassignment()==ai.getIdassignment()){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_INSERT_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = assignmentService.update(assignment);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
        }
        return result;
    }
}
