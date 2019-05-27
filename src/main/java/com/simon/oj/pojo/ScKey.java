package com.simon.oj.pojo;

public class ScKey {
    private Integer idclass;

    private String idstudent;

    public Integer getIdclass() {
        return idclass;
    }

    public void setIdclass(Integer idclass) {
        this.idclass = idclass;
    }

    public String getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(String idstudent) {
        this.idstudent = idstudent == null ? null : idstudent.trim();
    }
}