package com.simon.oj.pojo;

import java.util.Date;

public class Assignment {
    private Integer idassignment;

    private String title;

    private String idteacher;

    private Date commence;

    private Date deadline;

    private String status;

    public Integer getIdassignment() {
        return idassignment;
    }

    public void setIdassignment(Integer idassignment) {
        this.idassignment = idassignment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(String idteacher) {
        this.idteacher = idteacher == null ? null : idteacher.trim();
    }

    public Date getCommence() {
        return commence;
    }

    public void setCommence(Date commence) {
        this.commence = commence;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}