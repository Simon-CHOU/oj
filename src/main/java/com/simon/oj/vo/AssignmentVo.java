package com.simon.oj.vo;

import lombok.Data;

import java.util.Date;

/**
 * 前端作业列表展示
 */
@Data
public class AssignmentVo {
    private Integer idassignment;

    private String title;

    private String teacherName; // 数据库中是idteacher

    private Date commence;

    private Date deadline;

    private String status;
}
