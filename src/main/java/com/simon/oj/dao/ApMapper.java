package com.simon.oj.dao;

import com.simon.oj.pojo.Ap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApMapper {
    int deleteByPrimaryKey(@Param("idassignment") Integer idassignment, @Param("idproblem") Integer idproblem);

    int insert(Ap record);

    List<Ap> selectAll();
}