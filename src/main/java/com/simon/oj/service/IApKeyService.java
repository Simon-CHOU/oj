package com.simon.oj.service;

import com.simon.oj.pojo.ApKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IApKeyService {
    /**
     * 获取所有作业-题目列表
     * @return
     */
    List<ApKey> findApKeyList();

    /**
     * 一个作业包含的题目列表
     * @param idAssignment 作业号
     * @return ap 列表
     */
    List<ApKey> findApKeysByAid(Integer idAssignment);

    /**
     * 包含某个题目的所有作业
     * @param idproblem 题目ID
     * @return ac 列表
     */
    List<ApKey> findApKeysByPid(Integer idproblem);

    /**
     * 根据作业id统计作业包含的题目总数
     * @param idassignment 作业ID
     * @return 该作业包含的题目数
     */
    Long countNumOfProblemsByAssignmentId(Integer idassignment);

    /**
     * 增加一条作业-题目对应关系
     * @param apKey
     * @return
     */
    Integer addSingle(ApKey apKey);//尽管只有两个字段，但是联系紧密，还是传对象比较好

    /**
     * 作业下发到题目列表（题目接收作业），增加多条作业-题目对应关系
     * @param idassignment 要下发的作业id
     * @param idProblemList 下发题目列表
     * @return
     */
    Integer addBatch(Integer idassignment, List<Integer> idProblemList);


    /**
     * 更新一份作业包含的题目列表
     * @param idassignment 要更新的作业ID
     * @param  idProblemList 重新发布的题目列表
     * @return
     */
    Integer updateBatch(Integer idassignment, List<Integer> idProblemList);

    /**
     * 删除单个题目和作业的对应关系（从作业中移除某个题目）
     * @param apKey
     * @return
     */
    Integer deleteSingle(ApKey apKey);

    /**
     * 删除一份作业包含的题目
     * @param idassignment 要清楚题目列表的作业
     * @return
     */
    Integer deleteBatch(Integer idassignment);
}
