package com.simon.oj.dao;

import com.simon.oj.pojo.Assignment;
import com.simon.oj.pojo.AssignmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssignmentMapper {
    long countByExample(AssignmentExample example);

    int deleteByExample(AssignmentExample example);

    int deleteByPrimaryKey(Integer idassignment);

    int insert(Assignment record);

    int insertSelective(Assignment record);

    List<Assignment> selectByExample(AssignmentExample example);

    Assignment selectByPrimaryKey(Integer idassignment);

    int updateByExampleSelective(@Param("record") Assignment record, @Param("example") AssignmentExample example);

    int updateByExample(@Param("record") Assignment record, @Param("example") AssignmentExample example);

    int updateByPrimaryKeySelective(Assignment record);

    int updateByPrimaryKey(Assignment record);
}