package com.simon.oj.service;

import com.simon.oj.pojo.Submit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISubmitService {
    List<Submit> findSubmitList();
    Submit findSubmitById(Integer id);
    Integer add(Submit submit);//提交的很多字段需要执行后补充，但初始还是要有好几个字段，还是传对象为宜
    Integer update(Submit submit);
    Integer delete(Integer id);

}
