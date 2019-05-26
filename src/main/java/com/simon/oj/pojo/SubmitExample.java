package com.simon.oj.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubmitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubmitExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdsubmitIsNull() {
            addCriterion("idsubmit is null");
            return (Criteria) this;
        }

        public Criteria andIdsubmitIsNotNull() {
            addCriterion("idsubmit is not null");
            return (Criteria) this;
        }

        public Criteria andIdsubmitEqualTo(Integer value) {
            addCriterion("idsubmit =", value, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitNotEqualTo(Integer value) {
            addCriterion("idsubmit <>", value, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitGreaterThan(Integer value) {
            addCriterion("idsubmit >", value, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitGreaterThanOrEqualTo(Integer value) {
            addCriterion("idsubmit >=", value, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitLessThan(Integer value) {
            addCriterion("idsubmit <", value, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitLessThanOrEqualTo(Integer value) {
            addCriterion("idsubmit <=", value, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitIn(List<Integer> values) {
            addCriterion("idsubmit in", values, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitNotIn(List<Integer> values) {
            addCriterion("idsubmit not in", values, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitBetween(Integer value1, Integer value2) {
            addCriterion("idsubmit between", value1, value2, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdsubmitNotBetween(Integer value1, Integer value2) {
            addCriterion("idsubmit not between", value1, value2, "idsubmit");
            return (Criteria) this;
        }

        public Criteria andIdstudentIsNull() {
            addCriterion("idstudent is null");
            return (Criteria) this;
        }

        public Criteria andIdstudentIsNotNull() {
            addCriterion("idstudent is not null");
            return (Criteria) this;
        }

        public Criteria andIdstudentEqualTo(String value) {
            addCriterion("idstudent =", value, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentNotEqualTo(String value) {
            addCriterion("idstudent <>", value, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentGreaterThan(String value) {
            addCriterion("idstudent >", value, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentGreaterThanOrEqualTo(String value) {
            addCriterion("idstudent >=", value, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentLessThan(String value) {
            addCriterion("idstudent <", value, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentLessThanOrEqualTo(String value) {
            addCriterion("idstudent <=", value, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentLike(String value) {
            addCriterion("idstudent like", value, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentNotLike(String value) {
            addCriterion("idstudent not like", value, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentIn(List<String> values) {
            addCriterion("idstudent in", values, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentNotIn(List<String> values) {
            addCriterion("idstudent not in", values, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentBetween(String value1, String value2) {
            addCriterion("idstudent between", value1, value2, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdstudentNotBetween(String value1, String value2) {
            addCriterion("idstudent not between", value1, value2, "idstudent");
            return (Criteria) this;
        }

        public Criteria andIdproblemIsNull() {
            addCriterion("idproblem is null");
            return (Criteria) this;
        }

        public Criteria andIdproblemIsNotNull() {
            addCriterion("idproblem is not null");
            return (Criteria) this;
        }

        public Criteria andIdproblemEqualTo(Integer value) {
            addCriterion("idproblem =", value, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemNotEqualTo(Integer value) {
            addCriterion("idproblem <>", value, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemGreaterThan(Integer value) {
            addCriterion("idproblem >", value, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemGreaterThanOrEqualTo(Integer value) {
            addCriterion("idproblem >=", value, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemLessThan(Integer value) {
            addCriterion("idproblem <", value, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemLessThanOrEqualTo(Integer value) {
            addCriterion("idproblem <=", value, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemIn(List<Integer> values) {
            addCriterion("idproblem in", values, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemNotIn(List<Integer> values) {
            addCriterion("idproblem not in", values, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemBetween(Integer value1, Integer value2) {
            addCriterion("idproblem between", value1, value2, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdproblemNotBetween(Integer value1, Integer value2) {
            addCriterion("idproblem not between", value1, value2, "idproblem");
            return (Criteria) this;
        }

        public Criteria andIdassignmentIsNull() {
            addCriterion("idassignment is null");
            return (Criteria) this;
        }

        public Criteria andIdassignmentIsNotNull() {
            addCriterion("idassignment is not null");
            return (Criteria) this;
        }

        public Criteria andIdassignmentEqualTo(Integer value) {
            addCriterion("idassignment =", value, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentNotEqualTo(Integer value) {
            addCriterion("idassignment <>", value, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentGreaterThan(Integer value) {
            addCriterion("idassignment >", value, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("idassignment >=", value, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentLessThan(Integer value) {
            addCriterion("idassignment <", value, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentLessThanOrEqualTo(Integer value) {
            addCriterion("idassignment <=", value, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentIn(List<Integer> values) {
            addCriterion("idassignment in", values, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentNotIn(List<Integer> values) {
            addCriterion("idassignment not in", values, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentBetween(Integer value1, Integer value2) {
            addCriterion("idassignment between", value1, value2, "idassignment");
            return (Criteria) this;
        }

        public Criteria andIdassignmentNotBetween(Integer value1, Integer value2) {
            addCriterion("idassignment not between", value1, value2, "idassignment");
            return (Criteria) this;
        }

        public Criteria andSourcecodeIsNull() {
            addCriterion("sourcecode is null");
            return (Criteria) this;
        }

        public Criteria andSourcecodeIsNotNull() {
            addCriterion("sourcecode is not null");
            return (Criteria) this;
        }

        public Criteria andSourcecodeEqualTo(String value) {
            addCriterion("sourcecode =", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeNotEqualTo(String value) {
            addCriterion("sourcecode <>", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeGreaterThan(String value) {
            addCriterion("sourcecode >", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeGreaterThanOrEqualTo(String value) {
            addCriterion("sourcecode >=", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeLessThan(String value) {
            addCriterion("sourcecode <", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeLessThanOrEqualTo(String value) {
            addCriterion("sourcecode <=", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeLike(String value) {
            addCriterion("sourcecode like", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeNotLike(String value) {
            addCriterion("sourcecode not like", value, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeIn(List<String> values) {
            addCriterion("sourcecode in", values, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeNotIn(List<String> values) {
            addCriterion("sourcecode not in", values, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeBetween(String value1, String value2) {
            addCriterion("sourcecode between", value1, value2, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andSourcecodeNotBetween(String value1, String value2) {
            addCriterion("sourcecode not between", value1, value2, "sourcecode");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andCompilerIsNull() {
            addCriterion("compiler is null");
            return (Criteria) this;
        }

        public Criteria andCompilerIsNotNull() {
            addCriterion("compiler is not null");
            return (Criteria) this;
        }

        public Criteria andCompilerEqualTo(String value) {
            addCriterion("compiler =", value, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerNotEqualTo(String value) {
            addCriterion("compiler <>", value, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerGreaterThan(String value) {
            addCriterion("compiler >", value, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerGreaterThanOrEqualTo(String value) {
            addCriterion("compiler >=", value, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerLessThan(String value) {
            addCriterion("compiler <", value, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerLessThanOrEqualTo(String value) {
            addCriterion("compiler <=", value, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerLike(String value) {
            addCriterion("compiler like", value, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerNotLike(String value) {
            addCriterion("compiler not like", value, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerIn(List<String> values) {
            addCriterion("compiler in", values, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerNotIn(List<String> values) {
            addCriterion("compiler not in", values, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerBetween(String value1, String value2) {
            addCriterion("compiler between", value1, value2, "compiler");
            return (Criteria) this;
        }

        public Criteria andCompilerNotBetween(String value1, String value2) {
            addCriterion("compiler not between", value1, value2, "compiler");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputIsNull() {
            addCriterion("console_output is null");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputIsNotNull() {
            addCriterion("console_output is not null");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputEqualTo(String value) {
            addCriterion("console_output =", value, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputNotEqualTo(String value) {
            addCriterion("console_output <>", value, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputGreaterThan(String value) {
            addCriterion("console_output >", value, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputGreaterThanOrEqualTo(String value) {
            addCriterion("console_output >=", value, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputLessThan(String value) {
            addCriterion("console_output <", value, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputLessThanOrEqualTo(String value) {
            addCriterion("console_output <=", value, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputLike(String value) {
            addCriterion("console_output like", value, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputNotLike(String value) {
            addCriterion("console_output not like", value, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputIn(List<String> values) {
            addCriterion("console_output in", values, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputNotIn(List<String> values) {
            addCriterion("console_output not in", values, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputBetween(String value1, String value2) {
            addCriterion("console_output between", value1, value2, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andConsoleOutputNotBetween(String value1, String value2) {
            addCriterion("console_output not between", value1, value2, "consoleOutput");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andSpaceIsNull() {
            addCriterion("space is null");
            return (Criteria) this;
        }

        public Criteria andSpaceIsNotNull() {
            addCriterion("space is not null");
            return (Criteria) this;
        }

        public Criteria andSpaceEqualTo(Integer value) {
            addCriterion("space =", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotEqualTo(Integer value) {
            addCriterion("space <>", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceGreaterThan(Integer value) {
            addCriterion("space >", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("space >=", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLessThan(Integer value) {
            addCriterion("space <", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceLessThanOrEqualTo(Integer value) {
            addCriterion("space <=", value, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceIn(List<Integer> values) {
            addCriterion("space in", values, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotIn(List<Integer> values) {
            addCriterion("space not in", values, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceBetween(Integer value1, Integer value2) {
            addCriterion("space between", value1, value2, "space");
            return (Criteria) this;
        }

        public Criteria andSpaceNotBetween(Integer value1, Integer value2) {
            addCriterion("space not between", value1, value2, "space");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}