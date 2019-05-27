package com.simon.oj.service;

import com.simon.oj.pojo.AcKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAcKeyService {
    /**
     * 获取所有作业-班级下发列表
     * @return
     */
    List<AcKey> findAcKeyList();

    /**
     * 一个作业派发给的所有班级
     * @param idAssignment 作业号
     * @return ac 列表
     */
    List<AcKey> findAcKeysByAid(Integer idAssignment);

    /**
     * 一个班级接收的所有作业
     * @param idclass 班级ID
     * @return ac 列表
     */
    List<AcKey> findAcKeysByCid(Integer idclass);

    /**
     * 根据班级id统计某班接收的作业总数
     * @param idclass 班级ID
     * @return 该班接收的作业数
     */
    Long countNumOfAssignmentsByClassUId(Integer idclass);

    /**
     * 增加一条作业-班级对应关系
     * @param acKey
     * @return
     */
    Integer addSingle(AcKey acKey);//尽管只有两个字段，但是联系紧密，还是传对象比较好

    /**
     * 作业下发到班级列表（班级接收作业），增加多条作业-班级对应关系
     * @param idassignment 要下发的作业id
     * @param idClassList 下发班级列表
     * @return
     */
    Integer addBatch(Integer idassignment, List<Integer> idClassList);
    //另一种传参是作业id,和要下发的班级列表。还是传对象列表简单一些。<---这是错误的观点
    //List<AcKey> acKeyList 这种方式传参，隐藏了List中，每一个AcKey的idassignment都是一样的这条信息
    // 为了最大程度第表达函数功能的意思：“同一个作业，不同的班级”
    //参数 改成(Integer idassignment, List<Integer> idClassList)
    //deleteBatch和updateBatch也一样

    /**
     * 更改作业和班级的单个对应关系，（作业发布后，作业开始前可以修改发布到的班级）
     * @param acKey
     * @return
     */
//     Integer updateSingle(AcKey acKey);//一共两个字段，都是主键，单独Update一条记录没啥用

    /**
     * 更新作业发布班级
     * @param idassignment 要更新的作业ID
     * @param  idClassList 重新发布的班级列表
     * @return
     */
     Integer updateBatch(Integer idassignment, List<Integer> idClassList);//修改作业时，用新的派遣列表替换旧的

    /**
     * 删除单个作业和班级的对应关系（班级移除作业）
     * @param acKey
     * @return
     */
    Integer deleteSingle(AcKey acKey);

    /**
     * 删除一份作业派遣，删除这个作业的所有发布记录
     * @param idassignment 要取消发布的作业
     * @return
     */
    Integer deleteBatch(Integer idassignment);
}
