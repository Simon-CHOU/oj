package com.simon.oj.controller;

import com.simon.oj.common.Result;
import com.simon.oj.common.ResultCode;
import com.simon.oj.pojo.ScExample;
import com.simon.oj.pojo.ScKey;
import com.simon.oj.service.impl.ScKeyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sckey")
public class ScKeyController {
    @Autowired
    private ScKeyServiceImpl scKeyService;

    @GetMapping(value = "/list")
    public Result getScKeys(){
        return Result.success(scKeyService.findScKeyList());
    }

    @GetMapping(value = "/student")
    public Result getScKeysBySid(@RequestParam(value = "idstudent")String idstudent){
        Result result = new Result();
        try{
            List<ScKey> scKeyList =  scKeyService.findScKeysBySid(idstudent);
            if(!scKeyList.isEmpty()){
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(scKeyList);
            }else {
                result.setResultCode(ResultCode.RESULE_DATA_NONE);
            }
        }catch (Exception e){
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_RETRIEVE_WRONG);
        }
        return  result;
    }

    @GetMapping(value = "/class")
    public Result getScKeysByCid(@RequestParam(value = "idclass")Integer idclass){
        Result result = new Result();
        try{
            List<ScKey> scKeyList =  scKeyService.findScKeysByCid(idclass);
            if(!scKeyList.isEmpty()){
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(scKeyList);
            }else {
                result.setResultCode(ResultCode.RESULE_DATA_NONE);
            }
        }catch (Exception e){
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_RETRIEVE_WRONG);
        }
        return  result;
    }

    @GetMapping
    public Result countNumOfStudentsByClassUId(@RequestParam(value = "idclass")Integer idclass){
        Result result = new Result();
        try{
            Long numOfStudent = scKeyService.countNumOfStudentsByClassUId(idclass);
            if(numOfStudent!=null){
                result.setResultCode(ResultCode.SUCCESS);
                result.setData(numOfStudent);
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
    public Result addScKeys(@RequestBody ScKey scKey){
        Result result = new Result();
        try {
            int t =  scKeyService.add(scKey);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_INSERT_WRONG);
        }
        return result;
    }

    @DeleteMapping
    public Result deleteKeys(@RequestBody ScKey scKey){
        //验证key存在
        List<ScKey> slist = scKeyService.findScKeyList();
        int flag =0;
        for (ScKey sci:slist
        ) {
            if(scKey.getIdclass().equals(sci.getIdclass())&&
                    scKey.getIdstudent().equals(sci.getIdstudent())){flag =1;};
        }
        if(flag==0){
            return Result.failure(ResultCode.DATA_DELETE_NOT_FOUND);//要删除的数据不存在
        }

        Result result = new Result();
        try {
            int t = scKeyService.delete(scKey);;
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            System.out.println(e);
            result.setResultCode(ResultCode.DATA_DELETE_WRONG);
        }
        return result;
    }

}
