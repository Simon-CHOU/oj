package com.simon.oj.dao;

import com.simon.oj.pojo.ClassU;
import com.simon.oj.pojo.ClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(Integer idclass);

    int insert(ClassU record);

    int insertSelective(ClassU record);

    List<ClassU> selectByExample(ClassExample example);

    ClassU selectByPrimaryKey(Integer idclass);

    int updateByExampleSelective(@Param("record") ClassU record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") ClassU record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(ClassU record);

    int updateByPrimaryKey(ClassU record);
}