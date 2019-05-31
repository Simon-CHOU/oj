package com.simon.oj.service.impl;

import com.simon.oj.dao.AssignmentMapper;
import com.simon.oj.dao.TeacherMapper;
import com.simon.oj.pojo.*;
import com.simon.oj.service.IAssignmentService;
import com.simon.oj.vo.AssignmentClassVo;
import com.simon.oj.vo.AssignmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentServiceImpl implements IAssignmentService {
    @Autowired
    private AssignmentMapper assignmentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ScKeyServiceImpl scKeyService;
    @Autowired
    private AcKeyServiceImpl acKeyService;
    @Autowired
    private ClassUServiceImpl classUService;

    @Override
    public Assignment findAssignmentById(Integer id)  throws DataAccessException {
        return assignmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Assignment> findAssignmentList()  throws DataAccessException{
        return assignmentMapper.selectByExample(new AssignmentExample());
    }

    @Override
    public Integer add(Assignment assignment)  throws DataAccessException{
        return assignmentMapper.insert(assignment);
    }

    @Override
    public Integer update(Assignment assignment)  throws DataAccessException{
        return assignmentMapper.updateByPrimaryKey(assignment);
    }

    @Override
    public Integer delete(Integer id)  throws DataAccessException{
        return assignmentMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<AssignmentVo> findAssignmentVoList() throws DataAccessException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Assignment> alist = assignmentMapper.selectByExample(new AssignmentExample());
        List<AssignmentVo> avolist = new ArrayList<>();
        for (Assignment ia:alist
             ) {
            AssignmentVo temp = new AssignmentVo();
            temp.setIdassignment(ia.getIdassignment());//id
            temp.setTitle(ia.getTitle());//标题
            String idteacher = ia.getIdteacher();
            String teacherName =   teacherMapper.selectByPrimaryKey(idteacher).getName();
            temp.setTeacherName(teacherName);//出题老师
            temp.setCommence(sdf.format(ia.getCommence()));//开始日期
            temp.setDeadline(sdf.format(ia.getDeadline()));//结束日期
            temp.setStatus(ia.getStatus());//当前状态
            avolist.add(temp);
        }
        return avolist;
    }

    @Override
    public List<AssignmentVo> getAssignmentsVoByStuId(String idstudent) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<AssignmentVo> avolist = new ArrayList<>();//收纳查询出来的作业的列表
        List<ScKey> scKeyList = scKeyService.findScKeysBySid(idstudent);//查找学生加入的班级
        for (ScKey i:scKeyList
             ) {
            Integer idclass = i.getIdclass();//获取一个班级列表
            //根据班级查班级接收的作业id列表
            List<AcKey> acKeyList = acKeyService.findAcKeysByCid(idclass);
            for (AcKey j: acKeyList
                 ) {
                Integer idassignment = j.getIdassignment();//获取到作业的id
                //根据作业id将作业记录查询出来
                Assignment a = assignmentMapper.selectByPrimaryKey(idassignment);
                AssignmentVo temp = new AssignmentVo();
                temp.setIdassignment(a.getIdassignment());//id
                temp.setTitle(a.getTitle());//标题
                String idteacher = a.getIdteacher();
                String teacherName =   teacherMapper.selectByPrimaryKey(idteacher).getName();
                temp.setTeacherName(teacherName);//出题老师
                temp.setCommence(sdf.format(a.getCommence()));//开始日期
                temp.setDeadline(sdf.format(a.getDeadline()));//结束日期
                temp.setStatus(a.getStatus());//当前状态
                avolist.add(temp);
            }
        }
        return avolist;
    }


    @Override
    public List<AssignmentClassVo> getAssignmentsClassVoByTeaId(String idteacher) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        AssignmentExample example = new AssignmentExample();
        AssignmentExample.Criteria criteria = example.createCriteria();
        criteria.andIdteacherEqualTo(idteacher);
        List<Assignment> alist = assignmentMapper.selectByExample(example);
        List<AssignmentClassVo> asvlist = new ArrayList<>();
        for (Assignment i:alist
             ) {
            AssignmentClassVo temp = new AssignmentClassVo();
            temp.setIdassignment(i.getIdassignment());
            temp.setTitle(i.getTitle());
            temp.setCommence(sdf.format(i.getCommence()));
            temp.setDeadline(sdf.format(i.getDeadline()));
            temp.setStatus(i.getStatus());
            //在ac表中查询班级id列表
             List<AcKey> aclist =  acKeyService.findAcKeysByAid(i.getIdassignment());
             List<String> classNameList = new ArrayList<>();
            for (AcKey j: aclist
                 ) {
                Integer idclass = j.getIdclass();
                ClassU classU = classUService.findClassUById(idclass);//找到一个班级
                classNameList.add(classU.getClassname());
            }
            temp.setClassNames(classNameList);//将班级名赋值，至此赋值完毕
            asvlist.add(temp);//将赋值好的临时变量加入将要返回的vo列表
        }
        return asvlist;
    }
}
