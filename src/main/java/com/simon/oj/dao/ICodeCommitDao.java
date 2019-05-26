package com.simon.oj.dao;

import com.simon.oj.pojo.CodeCommit;

import java.util.List;

public interface ICodeCommitDao {
    int add(CodeCommit codeCommit);//添加纪录
    int update(CodeCommit codeCommit);
    int delete(int id);
    CodeCommit findProblemById();
    List<CodeCommit> findProblemList();
}
