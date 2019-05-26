package com.simon.oj.pojo;

import java.util.Date;

public class Submit {
    private Integer idsubmit;

    private String idstudent;

    private Integer idproblem;

    private Integer idassignment;

    private String sourcecode;

    private Date time;

    private String compiler;

    private String consoleOutput;

    private String result;

    private Integer duration;

    private Integer space;

    private Integer score;

    public Integer getIdsubmit() {
        return idsubmit;
    }

    public void setIdsubmit(Integer idsubmit) {
        this.idsubmit = idsubmit;
    }

    public String getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(String idstudent) {
        this.idstudent = idstudent == null ? null : idstudent.trim();
    }

    public Integer getIdproblem() {
        return idproblem;
    }

    public void setIdproblem(Integer idproblem) {
        this.idproblem = idproblem;
    }

    public Integer getIdassignment() {
        return idassignment;
    }

    public void setIdassignment(Integer idassignment) {
        this.idassignment = idassignment;
    }

    public String getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(String sourcecode) {
        this.sourcecode = sourcecode == null ? null : sourcecode.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCompiler() {
        return compiler;
    }

    public void setCompiler(String compiler) {
        this.compiler = compiler == null ? null : compiler.trim();
    }

    public String getConsoleOutput() {
        return consoleOutput;
    }

    public void setConsoleOutput(String consoleOutput) {
        this.consoleOutput = consoleOutput == null ? null : consoleOutput.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}