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

    private String commence;//Date 太精确，只需要到天就可以了

    private String deadline;

    private String status;
}
