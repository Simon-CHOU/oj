package com.simon.oj.service;

import com.simon.oj.pojo.Assignment;
import com.simon.oj.vo.AssignmentClassVo;
import com.simon.oj.vo.AssignmentVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAssignmentService {
    Assignment findAssignmentById(Integer id);

    /**
     * 查询原始作业数据表
     * @return
     */
    List<Assignment> findAssignmentList();
    Integer add(Assignment assignment);//字段太多所以传对象
    Integer update(Assignment assignment);
    Integer delete(Integer id);

    /**
     * 查询用于显示的数据表
     * @return
     */
    List<AssignmentVo> findAssignmentVoList();

    /**
     * 根据学生姓名查找学生所在班级下发的作业列表
     * @param idstudent
     * @return
     */
    List<AssignmentVo> getAssignmentsVoByStuId(String idstudent);

    /**
     * 根据教师的id查找该教师下发的作业列表，作业包含派发的班级
     * @param idteacher
     * @return
     */
    List<AssignmentClassVo> getAssignmentsClassVoByTeaId(String idteacher);
}
