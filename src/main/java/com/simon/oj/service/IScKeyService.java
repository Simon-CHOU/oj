package com.simon.oj.service;

import com.simon.oj.pojo.ScKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IScKeyService {
    List<ScKey> findScKeyList();

    /**
     * 一个学生参加的所有班级
     * @param idstudent
     * @return sc 列表
     */
    List<ScKey> findScKeysBySid(String idstudent);//注意学号是string

    /**
     * 一个班级包含的所有学生
     * @param idclass 班级ID
     * @return sc 列表
     */
    List<ScKey> findScKeysByCid(Integer idclass);//注意班级号是int

    /**
     * 根据班级id统计某班的人数
     * @param idclass 班级ID
     * @return 该班人数
     */
    Long countNumOfStudentsByClassUId(Integer idclass);

    /**
     * 学生加入班级（班级接收学生）
     * @param scKey
     * @return
     */
    Integer add(ScKey scKey);//尽管只有两个字段，但是联系紧密，还是传对象比较好

    /**
     * 更改学生和班级的对应关系，似乎不太用得上
     * @param scKey
     * @return
     */
//     Integer update(ScKey scKey);

    /**
     * 学生退出班级（班级移除学生）
     * @param scKey
     * @return
     */
    Integer delete(ScKey scKey);

    //暂时没有根据一个班更新、删除所有的学生，或者一个学生更新删除所有班级的需要
    //    Integer updateBySid(Integer idstudent);
//    Integer updateByCid(Integer idstudent);
//    Integer deleteBySid(Integer idstudent);
//    Integer deleteByCid(Integer idstudent);
}
