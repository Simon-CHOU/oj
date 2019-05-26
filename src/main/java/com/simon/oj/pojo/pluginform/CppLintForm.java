package com.simon.oj.pojo.pluginform;

/**
 * Cpplint 前端页面表单对应的实体类
 */
public class CppLintForm {
    private Integer score;//分数设置
    private String funcAnnotation;//检查函数注释
    private String variableName;// 检查变量命名
    private String nestedLoop;//检查循环嵌套次数
    private String nestedSelect;//检查选择嵌套次数
    private String checkExtend;//其他检查项：按照命令行参数给与

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFuncAnnotation() {
        return funcAnnotation;
    }

    public void setFuncAnnotation(String funcAnnotation) {
        this.funcAnnotation = funcAnnotation;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getNestedLoop() {
        return nestedLoop;
    }

    public void setNestedLoop(String nestedLoop) {
        this.nestedLoop = nestedLoop;
    }

    public String getNestedSelect() {
        return nestedSelect;
    }

    public void setNestedSelect(String nestedSelect) {
        this.nestedSelect = nestedSelect;
    }

    public String getCheckExtend() {
        return checkExtend;
    }

    public void setCheckExtend(String checkExtend) {
        this.checkExtend = checkExtend;
    }

    @Override
    public String toString() {
        return "CppLintForm{" +
                "score=" + score +
                ", funcAnnotation=" + funcAnnotation +
                ", variableName=" + variableName +
                ", nestedLoop=" + nestedLoop +
                ", nestedSelect=" + nestedSelect +
                ", checkExtend='" + checkExtend + '\'' +
                '}';
    }
}
