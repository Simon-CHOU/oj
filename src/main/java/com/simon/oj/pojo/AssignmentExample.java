package com.simon.oj.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssignmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssignmentExample() {
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

        public Criteria andIdteacherIsNull() {
            addCriterion("idteacher is null");
            return (Criteria) this;
        }

        public Criteria andIdteacherIsNotNull() {
            addCriterion("idteacher is not null");
            return (Criteria) this;
        }

        public Criteria andIdteacherEqualTo(String value) {
            addCriterion("idteacher =", value, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherNotEqualTo(String value) {
            addCriterion("idteacher <>", value, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherGreaterThan(String value) {
            addCriterion("idteacher >", value, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherGreaterThanOrEqualTo(String value) {
            addCriterion("idteacher >=", value, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherLessThan(String value) {
            addCriterion("idteacher <", value, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherLessThanOrEqualTo(String value) {
            addCriterion("idteacher <=", value, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherLike(String value) {
            addCriterion("idteacher like", value, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherNotLike(String value) {
            addCriterion("idteacher not like", value, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherIn(List<String> values) {
            addCriterion("idteacher in", values, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherNotIn(List<String> values) {
            addCriterion("idteacher not in", values, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherBetween(String value1, String value2) {
            addCriterion("idteacher between", value1, value2, "idteacher");
            return (Criteria) this;
        }

        public Criteria andIdteacherNotBetween(String value1, String value2) {
            addCriterion("idteacher not between", value1, value2, "idteacher");
            return (Criteria) this;
        }

        public Criteria andCommenceIsNull() {
            addCriterion("commence is null");
            return (Criteria) this;
        }

        public Criteria andCommenceIsNotNull() {
            addCriterion("commence is not null");
            return (Criteria) this;
        }

        public Criteria andCommenceEqualTo(Date value) {
            addCriterion("commence =", value, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceNotEqualTo(Date value) {
            addCriterion("commence <>", value, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceGreaterThan(Date value) {
            addCriterion("commence >", value, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceGreaterThanOrEqualTo(Date value) {
            addCriterion("commence >=", value, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceLessThan(Date value) {
            addCriterion("commence <", value, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceLessThanOrEqualTo(Date value) {
            addCriterion("commence <=", value, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceIn(List<Date> values) {
            addCriterion("commence in", values, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceNotIn(List<Date> values) {
            addCriterion("commence not in", values, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceBetween(Date value1, Date value2) {
            addCriterion("commence between", value1, value2, "commence");
            return (Criteria) this;
        }

        public Criteria andCommenceNotBetween(Date value1, Date value2) {
            addCriterion("commence not between", value1, value2, "commence");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterion("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterion("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterion("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterion("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterion("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterion("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterion("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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