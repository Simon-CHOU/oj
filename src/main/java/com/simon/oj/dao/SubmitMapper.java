package com.simon.oj.dao;

import com.simon.oj.pojo.Submit;
import com.simon.oj.pojo.SubmitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubmitMapper {
    long countByExample(SubmitExample example);

    int deleteByExample(SubmitExample example);

    int deleteByPrimaryKey(Integer idsubmit);

    int insert(Submit record);

    int insertSelective(Submit record);

    List<Submit> selectByExample(SubmitExample example);

    Submit selectByPrimaryKey(Integer idsubmit);

    int updateByExampleSelective(@Param("record") Submit record, @Param("example") SubmitExample example);

    int updateByExample(@Param("record") Submit record, @Param("example") SubmitExample example);

    int updateByPrimaryKeySelective(Submit record);

    int updateByPrimaryKey(Submit record);
}