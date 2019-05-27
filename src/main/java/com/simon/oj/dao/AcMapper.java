package com.simon.oj.dao;

import com.simon.oj.pojo.AcExample;
import com.simon.oj.pojo.AcKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcMapper {
    long countByExample(AcExample example);

    int deleteByExample(AcExample example);

    int deleteByPrimaryKey(AcKey key);

    int insert(AcKey record);

    int insertSelective(AcKey record);

    List<AcKey> selectByExample(AcExample example);

    int updateByExampleSelective(@Param("record") AcKey record, @Param("example") AcExample example);

    int updateByExample(@Param("record") AcKey record, @Param("example") AcExample example);
}