package com.simon.oj.pojo;

import java.util.Date;

public class Class {
    private Integer idclass;

    private String classname;

    private String idteacher;

    private String semester;

    private Integer stuAmount;

    private Date opendate;

    private Date closedate;

    private String status;

    public Integer getIdclass() {
        return idclass;
    }

    public void setIdclass(Integer idclass) {
        this.idclass = idclass;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(String idteacher) {
        this.idteacher = idteacher == null ? null : idteacher.trim();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }

    public Integer getStuAmount() {
        return stuAmount;
    }

    public void setStuAmount(Integer stuAmount) {
        this.stuAmount = stuAmount;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public Date getClosedate() {
        return closedate;
    }

    public void setClosedate(Date closedate) {
        this.closedate = closedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}