package com.simon.oj.dao;

import com.simon.oj.pojo.Sc;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScMapper {
    int deleteByPrimaryKey(@Param("idclass") Integer idclass, @Param("idstudent") String idstudent);

    int insert(Sc record);

    List<Sc> selectAll();
}