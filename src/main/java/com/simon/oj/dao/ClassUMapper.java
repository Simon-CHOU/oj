package com.simon.oj.dao;

import com.simon.oj.pojo.ClassU;
import com.simon.oj.pojo.ClassUExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassUMapper {
    long countByExample(ClassUExample example);

    int deleteByExample(ClassUExample example);

    int deleteByPrimaryKey(Integer idclass);

    int insert(ClassU record);

    int insertSelective(ClassU record);

    List<ClassU> selectByExample(ClassUExample example);

    ClassU selectByPrimaryKey(Integer idclass);

    int updateByExampleSelective(@Param("record") ClassU record, @Param("example") ClassUExample example);

    int updateByExample(@Param("record") ClassU record, @Param("example") ClassUExample example);

    int updateByPrimaryKeySelective(ClassU record);

    int updateByPrimaryKey(ClassU record);
}