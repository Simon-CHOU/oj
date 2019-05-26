package com.simon.oj.controller;

import com.simon.oj.common.Result;
import com.simon.oj.common.ResultCode;
import com.simon.oj.pojo.Problem;
import com.simon.oj.service.impl.ProblemServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemServiceImpl problemService;

    @GetMapping(value = "/list")
    public Result getProblems() {
        return Result.success(problemService.findProblemList());
    }

    @GetMapping
    public Result getProblemById(@RequestParam(value = "id") Integer id) {
        Result result = new Result();
        try {
            Problem t = problemService.findProblemById(id);
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
    public Result deleteProblem(@RequestParam(value = "id") Integer id) {
        //验证id存在
        List<Problem> plist = problemService.findProblemList();
        int flag =0;
        for (Problem pi:plist
             ) {
            if(id==pi.getIdproblem()){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = problemService.delete(id);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }

    @PostMapping
    public Result addProblem(@RequestBody Problem problem) {
        Result result = new Result();
        try {
            int t = problemService.add(problem);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @PutMapping
    public Result updateProblem(@RequestBody Problem problem) {
        Result result = new Result();
        try {
            int t = problemService.update(problem);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
        }
        return result;
    }

}
