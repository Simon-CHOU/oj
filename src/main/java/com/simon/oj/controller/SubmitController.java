package com.simon.oj.controller;

import com.simon.oj.comm.Result;
import com.simon.oj.comm.ResultCode;
import com.simon.oj.pojo.Submit;
import com.simon.oj.service.impl.SubmitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submit")
public class SubmitController {
    @Autowired
    private SubmitServiceImpl submitService;

    @GetMapping(value = "/list")
    public Result getSubmits() {
        return Result.success(submitService.findSubmitList());
    }

    @GetMapping
    public Result getSubmitById(@RequestParam(value = "id") Integer id) {
        Result result = new Result();
        try {
            Submit t = submitService.findSubmitById(id);
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
    public Result deleteSubmit(@RequestParam(value = "id") Integer id) {
        //验证id存在
        List<Submit> slist = submitService.findSubmitList();
        int flag =0;
        for (Submit si:slist
        ) {
            if(id==si.getIdsubmit()){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = submitService.delete(id);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }

    @PostMapping
    public Result addSubmit(@RequestBody Submit submit) {
        Result result = new Result();
        try {
            int t = submitService.add(submit);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @PutMapping
    public Result updateSubmit(@RequestBody Submit submit) {
        //验证id存在
        List<Submit> slist = submitService.findSubmitList();
        int flag =0;
        for (Submit si:slist
        ) {
            if(submit.getIdsubmit()==si.getIdsubmit()){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_INSERT_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = submitService.update(submit);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
        }
        return result;
    }

}
