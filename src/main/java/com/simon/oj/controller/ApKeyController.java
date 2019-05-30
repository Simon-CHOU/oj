package com.simon.oj.controller;

import com.alibaba.fastjson.JSONObject;
import com.simon.oj.comm.Result;
import com.simon.oj.comm.ResultCode;
import com.simon.oj.dto.AssignmentProblemListDto;
import com.simon.oj.pojo.ApKey;
import com.simon.oj.service.impl.ApKeyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apkey")
public class ApKeyController {
    @Autowired
    private ApKeyServiceImpl apKeyService;

    @GetMapping(value = "/list")
    public Result getApKeys() {
        return Result.success(apKeyService.findApKeyList());
    }

    @GetMapping(value = "/assignment")
    public Result getApKeysByAid(@RequestParam(value = "idassignment") Integer idassignment) {
        Result result = new Result();
        try {
            List<ApKey> apKeyList = apKeyService.findApKeysByAid(idassignment);
            if (!apKeyList.isEmpty()) {
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(apKeyList);
            } else {
                result.setResultCode(ResultCode.RESULE_DATA_NONE);
            }
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_RETRIEVE_WRONG);
        }
        return result;
    }

    @GetMapping(value = "/problem")
    public Result getApKeysByPid(@RequestParam(value = "idproblem") Integer idproblem) {
        Result result = new Result();
        try {
            List<ApKey> apKeyList = apKeyService.findApKeysByPid(idproblem);
            if (!apKeyList.isEmpty()) {
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(apKeyList);
            } else {
                result.setResultCode(ResultCode.RESULE_DATA_NONE);
            }
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_RETRIEVE_WRONG);
        }
        return result;
    }

    @GetMapping(value = "/count")
    public Result countNumOfProblemsByAssignmentId(@RequestParam(value = "idassignment") Integer idassignment) {
        //验证key存在
        List<ApKey> aplist = apKeyService.findApKeysByAid(idassignment);
        if (aplist.isEmpty()) {
            return Result.failure(ResultCode.RESULE_DATA_NONE);//要查找的作业不存在
        }

        Result result = new Result();
        try {
            Long numOfAssignment = apKeyService.countNumOfProblemsByAssignmentId(idassignment);
            if (numOfAssignment != null) {
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(numOfAssignment);
            } else {
                result.setResultCode(ResultCode.RESULE_DATA_NONE);
            }
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_RETRIEVE_WRONG);
        }
        return result;
    }

    @PostMapping
    public Result addApKey(@RequestBody ApKey apKey) {
        Result result = new Result();
        try {
            int t = apKeyService.addSingle(apKey);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @PostMapping(value = "/batch")
    public Result addApKeyBatchs(@RequestBody String assignmentClassListJson) {
        AssignmentProblemListDto assignmentClassListDto = JSONObject.parseObject(assignmentClassListJson,
                AssignmentProblemListDto.class);//json转对象
        Result result = new Result();
        try {
            int t = apKeyService.addBatch(assignmentClassListDto.getIdassignment(),
                    assignmentClassListDto.getIdProblemList());
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

//    @PutMapping
//    public Result updateApKey(@RequestBody ApKey apKey) {
//
//        Result result = new Result();
//        try {
//            int t = apKeyService.updateSingle(apKey);//没用
//            result.setResultCode(ResultCode.SUCCESS);
//        } catch (Exception e) {
//            System.out.println(e);
//            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
//        }
//        return result;
//    }

    @PutMapping(value = "/batch")
    public Result updateApKeyBatchs(@RequestBody String assignmentProblemListJson) {
        AssignmentProblemListDto assignmentClassListDto = JSONObject.parseObject(assignmentProblemListJson,
                AssignmentProblemListDto.class);//json转对象
        /* 对于请求传递JSON更方便。主要是传数组方便。所以用了Dto。
        * @RequestParam(value = "idassignment") Integer idassignment,
         @RequestParam(value = "idClassList[]") List<Integer> idClassList
        * */
        Result result = new Result();
        try {
            int t = apKeyService.updateBatch(assignmentClassListDto.getIdassignment(),
                    assignmentClassListDto.getIdProblemList());
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
        }
        return result;
    }

    @DeleteMapping
    public Result deleteKey(@RequestBody ApKey apKey) {
        //验证key存在
        List<ApKey> aplist = apKeyService.findApKeyList();
        int flag = 0;
        for (ApKey api : aplist
        ) {
            if (apKey.getIdassignment().equals(api.getIdassignment()) &&
                    apKey.getIdproblem().equals(api.getIdproblem())) {
                flag = 1;
            }
            ;
        }
        if (flag == 0) {
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = apKeyService.deleteSingle(apKey);
            ;
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }

    @DeleteMapping(value = "/batch")
    public Result deleteApKeyBatch(@RequestParam(value = "idassignment") Integer idassignment) {
        //验证key存在
        List<ApKey> aplist = apKeyService.findApKeysByAid(idassignment);//这里先查出作业已发布的班级
        if (aplist.isEmpty()) {
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = apKeyService.deleteBatch(idassignment);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }
}
