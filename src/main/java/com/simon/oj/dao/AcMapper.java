package com.simon.oj.dao;

import com.simon.oj.pojo.Ac;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcMapper {
    int deleteByPrimaryKey(@Param("idassignment") Integer idassignment, @Param("idclass") Integer idclass);

    int insert(Ac record);

    List<Ac> selectAll();
}