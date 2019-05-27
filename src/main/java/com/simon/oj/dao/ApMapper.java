package com.simon.oj.dao;

import com.simon.oj.pojo.ApExample;
import com.simon.oj.pojo.ApKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApMapper {
    long countByExample(ApExample example);

    int deleteByExample(ApExample example);

    int deleteByPrimaryKey(ApKey key);

    int insert(ApKey record);

    int insertSelective(ApKey record);

    List<ApKey> selectByExample(ApExample example);

    int updateByExampleSelective(@Param("record") ApKey record, @Param("example") ApExample example);

    int updateByExample(@Param("record") ApKey record, @Param("example") ApExample example);
}