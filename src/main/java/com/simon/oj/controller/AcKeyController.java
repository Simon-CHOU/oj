package com.simon.oj.controller;

import com.alibaba.fastjson.JSONObject;
import com.simon.oj.comm.Result;
import com.simon.oj.comm.ResultCode;
import com.simon.oj.dto.AssignmentClassListDto;
import com.simon.oj.pojo.AcKey;
import com.simon.oj.service.impl.AcKeyServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ackey")
public class AcKeyController {
    @Autowired
    private AcKeyServiceImpl acKeyService;

    @GetMapping(value = "/list")
    public Result getAcKeys() {
        return Result.success(acKeyService.findAcKeyList());
    }

    @GetMapping(value = "/assignment")
    public Result getAcKeysBySid(@RequestParam(value = "idassignment") Integer idassignment) {
        Result result = new Result();
        try {
            List<AcKey> acKeyList = acKeyService.findAcKeysByAid(idassignment);
            if (!acKeyList.isEmpty()) {
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(acKeyList);
            } else {
                result.setResultCode(ResultCode.RESULE_DATA_NONE);
            }
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_RETRIEVE_WRONG);
        }
        return result;
    }

    @GetMapping(value = "/class")
    public Result getAcKeysByCid(@RequestParam(value = "idclass") Integer idclass) {
        Result result = new Result();
        try {
            List<AcKey> acKeyList = acKeyService.findAcKeysByCid(idclass);
            if (!acKeyList.isEmpty()) {
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(acKeyList);
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
    public Result countNumOfAssignmentsByClassUId(@RequestParam(value = "idclass") Integer idclass) {
        //验证key存在
        List<AcKey> aclist = acKeyService.findAcKeysByCid(idclass);
        if (aclist.isEmpty()) {
            return Result.failure(ResultCode.RESULE_DATA_NONE);//要查找的班级不存在
        }

        Result result = new Result();
        try {
            Long numOfAssignment = acKeyService.countNumOfAssignmentsByClassUId(idclass);
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
    public Result addAcKey(@RequestBody AcKey acKey) {
        Result result = new Result();
        try {
            int t = acKeyService.addSingle(acKey);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @PostMapping(value = "/batch")
    public Result addAcKeyBatchs(@RequestBody String assignmentClassListJson) {
        AssignmentClassListDto assignmentClassListDto = JSONObject.parseObject(assignmentClassListJson,
                AssignmentClassListDto.class);//json转对象
        Result result = new Result();
        try {
            int t = acKeyService.addBatch(assignmentClassListDto.getIdassignment(),
                    assignmentClassListDto.getIdClassList());
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

//    @PutMapping
//    public Result updateAcKey(@RequestBody AcKey acKey) {
//
//        Result result = new Result();
//        try {
//            int t = acKeyService.updateSingle(acKey);//没用
//            result.setResultCode(ResultCode.SUCCESS);
//        } catch (Exception e) {
//            System.out.println(e);
//            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
//        }
//        return result;
//    }

    @PutMapping(value = "/batch")
    public Result updateAcKeyBatchs(@RequestBody String assignmentClassListJson) {
        AssignmentClassListDto assignmentClassListDto = JSONObject.parseObject(assignmentClassListJson,
                AssignmentClassListDto.class);//json转对象
        /* 对于请求传递JSON更方便。主要是传数组方便。所以用了Dto。
        * @RequestParam(value = "idassignment") Integer idassignment,
         @RequestParam(value = "idClassList[]") List<Integer> idClassList
        * */
        Result result = new Result();
        try {
            int t = acKeyService.updateBatch(assignmentClassListDto.getIdassignment(),
                    assignmentClassListDto.getIdClassList());
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_UPDATE_WRONG);
        }
        return result;
    }

    @DeleteMapping
    public Result deleteKey(@RequestBody AcKey acKey) {
        //验证key存在
        List<AcKey> aclist = acKeyService.findAcKeyList();
        int flag = 0;
        for (AcKey aci : aclist
        ) {
            if (acKey.getIdassignment().equals(aci.getIdassignment()) &&
                    acKey.getIdclass().equals(aci.getIdclass())) {
                flag = 1;
            }
            ;
        }
        if (flag == 0) {
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = acKeyService.deleteSingle(acKey);
            ;
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }

    @DeleteMapping(value = "/batch")
    public Result deleteAcKeyBatch(@RequestParam(value = "idassignment") Integer idassignment) {
        //验证key存在
        List<AcKey> aclist = acKeyService.findAcKeysByAid(idassignment);//这里先查出作业已发布的班级
        if (aclist.isEmpty()) {
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = acKeyService.deleteBatch(idassignment);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }

}
