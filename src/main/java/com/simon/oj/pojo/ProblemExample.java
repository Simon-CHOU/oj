package com.simon.oj.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProblemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProblemExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andInputIsNull() {
            addCriterion("input is null");
            return (Criteria) this;
        }

        public Criteria andInputIsNotNull() {
            addCriterion("input is not null");
            return (Criteria) this;
        }

        public Criteria andInputEqualTo(String value) {
            addCriterion("input =", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputNotEqualTo(String value) {
            addCriterion("input <>", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputGreaterThan(String value) {
            addCriterion("input >", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputGreaterThanOrEqualTo(String value) {
            addCriterion("input >=", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputLessThan(String value) {
            addCriterion("input <", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputLessThanOrEqualTo(String value) {
            addCriterion("input <=", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputLike(String value) {
            addCriterion("input like", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputNotLike(String value) {
            addCriterion("input not like", value, "input");
            return (Criteria) this;
        }

        public Criteria andInputIn(List<String> values) {
            addCriterion("input in", values, "input");
            return (Criteria) this;
        }

        public Criteria andInputNotIn(List<String> values) {
            addCriterion("input not in", values, "input");
            return (Criteria) this;
        }

        public Criteria andInputBetween(String value1, String value2) {
            addCriterion("input between", value1, value2, "input");
            return (Criteria) this;
        }

        public Criteria andInputNotBetween(String value1, String value2) {
            addCriterion("input not between", value1, value2, "input");
            return (Criteria) this;
        }

        public Criteria andOutputIsNull() {
            addCriterion("output is null");
            return (Criteria) this;
        }

        public Criteria andOutputIsNotNull() {
            addCriterion("output is not null");
            return (Criteria) this;
        }

        public Criteria andOutputEqualTo(String value) {
            addCriterion("output =", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotEqualTo(String value) {
            addCriterion("output <>", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThan(String value) {
            addCriterion("output >", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThanOrEqualTo(String value) {
            addCriterion("output >=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThan(String value) {
            addCriterion("output <", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThanOrEqualTo(String value) {
            addCriterion("output <=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLike(String value) {
            addCriterion("output like", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotLike(String value) {
            addCriterion("output not like", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputIn(List<String> values) {
            addCriterion("output in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotIn(List<String> values) {
            addCriterion("output not in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputBetween(String value1, String value2) {
            addCriterion("output between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotBetween(String value1, String value2) {
            addCriterion("output not between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andCommittedIsNull() {
            addCriterion("committed is null");
            return (Criteria) this;
        }

        public Criteria andCommittedIsNotNull() {
            addCriterion("committed is not null");
            return (Criteria) this;
        }

        public Criteria andCommittedEqualTo(Integer value) {
            addCriterion("committed =", value, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedNotEqualTo(Integer value) {
            addCriterion("committed <>", value, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedGreaterThan(Integer value) {
            addCriterion("committed >", value, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedGreaterThanOrEqualTo(Integer value) {
            addCriterion("committed >=", value, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedLessThan(Integer value) {
            addCriterion("committed <", value, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedLessThanOrEqualTo(Integer value) {
            addCriterion("committed <=", value, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedIn(List<Integer> values) {
            addCriterion("committed in", values, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedNotIn(List<Integer> values) {
            addCriterion("committed not in", values, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedBetween(Integer value1, Integer value2) {
            addCriterion("committed between", value1, value2, "committed");
            return (Criteria) this;
        }

        public Criteria andCommittedNotBetween(Integer value1, Integer value2) {
            addCriterion("committed not between", value1, value2, "committed");
            return (Criteria) this;
        }

        public Criteria andPassedIsNull() {
            addCriterion("passed is null");
            return (Criteria) this;
        }

        public Criteria andPassedIsNotNull() {
            addCriterion("passed is not null");
            return (Criteria) this;
        }

        public Criteria andPassedEqualTo(Integer value) {
            addCriterion("passed =", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedNotEqualTo(Integer value) {
            addCriterion("passed <>", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedGreaterThan(Integer value) {
            addCriterion("passed >", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedGreaterThanOrEqualTo(Integer value) {
            addCriterion("passed >=", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedLessThan(Integer value) {
            addCriterion("passed <", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedLessThanOrEqualTo(Integer value) {
            addCriterion("passed <=", value, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedIn(List<Integer> values) {
            addCriterion("passed in", values, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedNotIn(List<Integer> values) {
            addCriterion("passed not in", values, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedBetween(Integer value1, Integer value2) {
            addCriterion("passed between", value1, value2, "passed");
            return (Criteria) this;
        }

        public Criteria andPassedNotBetween(Integer value1, Integer value2) {
            addCriterion("passed not between", value1, value2, "passed");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
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