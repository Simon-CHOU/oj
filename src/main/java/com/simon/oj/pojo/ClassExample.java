package com.simon.oj.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassExample() {
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

        public Criteria andIdclassIsNull() {
            addCriterion("idclass is null");
            return (Criteria) this;
        }

        public Criteria andIdclassIsNotNull() {
            addCriterion("idclass is not null");
            return (Criteria) this;
        }

        public Criteria andIdclassEqualTo(Integer value) {
            addCriterion("idclass =", value, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassNotEqualTo(Integer value) {
            addCriterion("idclass <>", value, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassGreaterThan(Integer value) {
            addCriterion("idclass >", value, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassGreaterThanOrEqualTo(Integer value) {
            addCriterion("idclass >=", value, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassLessThan(Integer value) {
            addCriterion("idclass <", value, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassLessThanOrEqualTo(Integer value) {
            addCriterion("idclass <=", value, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassIn(List<Integer> values) {
            addCriterion("idclass in", values, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassNotIn(List<Integer> values) {
            addCriterion("idclass not in", values, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassBetween(Integer value1, Integer value2) {
            addCriterion("idclass between", value1, value2, "idclass");
            return (Criteria) this;
        }

        public Criteria andIdclassNotBetween(Integer value1, Integer value2) {
            addCriterion("idclass not between", value1, value2, "idclass");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("classname is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("classname is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("classname =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("classname <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("classname >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("classname >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("classname <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("classname <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("classname like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("classname not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("classname in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("classname not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("classname between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("classname not between", value1, value2, "classname");
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

        public Criteria andSemesterIsNull() {
            addCriterion("semester is null");
            return (Criteria) this;
        }

        public Criteria andSemesterIsNotNull() {
            addCriterion("semester is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterEqualTo(String value) {
            addCriterion("semester =", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotEqualTo(String value) {
            addCriterion("semester <>", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterGreaterThan(String value) {
            addCriterion("semester >", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterGreaterThanOrEqualTo(String value) {
            addCriterion("semester >=", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLessThan(String value) {
            addCriterion("semester <", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLessThanOrEqualTo(String value) {
            addCriterion("semester <=", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterLike(String value) {
            addCriterion("semester like", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotLike(String value) {
            addCriterion("semester not like", value, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterIn(List<String> values) {
            addCriterion("semester in", values, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotIn(List<String> values) {
            addCriterion("semester not in", values, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterBetween(String value1, String value2) {
            addCriterion("semester between", value1, value2, "semester");
            return (Criteria) this;
        }

        public Criteria andSemesterNotBetween(String value1, String value2) {
            addCriterion("semester not between", value1, value2, "semester");
            return (Criteria) this;
        }

        public Criteria andStuAmountIsNull() {
            addCriterion("stu_amount is null");
            return (Criteria) this;
        }

        public Criteria andStuAmountIsNotNull() {
            addCriterion("stu_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStuAmountEqualTo(Integer value) {
            addCriterion("stu_amount =", value, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountNotEqualTo(Integer value) {
            addCriterion("stu_amount <>", value, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountGreaterThan(Integer value) {
            addCriterion("stu_amount >", value, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_amount >=", value, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountLessThan(Integer value) {
            addCriterion("stu_amount <", value, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountLessThanOrEqualTo(Integer value) {
            addCriterion("stu_amount <=", value, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountIn(List<Integer> values) {
            addCriterion("stu_amount in", values, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountNotIn(List<Integer> values) {
            addCriterion("stu_amount not in", values, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountBetween(Integer value1, Integer value2) {
            addCriterion("stu_amount between", value1, value2, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andStuAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_amount not between", value1, value2, "stuAmount");
            return (Criteria) this;
        }

        public Criteria andOpendateIsNull() {
            addCriterion("opendate is null");
            return (Criteria) this;
        }

        public Criteria andOpendateIsNotNull() {
            addCriterion("opendate is not null");
            return (Criteria) this;
        }

        public Criteria andOpendateEqualTo(Date value) {
            addCriterion("opendate =", value, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateNotEqualTo(Date value) {
            addCriterion("opendate <>", value, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateGreaterThan(Date value) {
            addCriterion("opendate >", value, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateGreaterThanOrEqualTo(Date value) {
            addCriterion("opendate >=", value, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateLessThan(Date value) {
            addCriterion("opendate <", value, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateLessThanOrEqualTo(Date value) {
            addCriterion("opendate <=", value, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateIn(List<Date> values) {
            addCriterion("opendate in", values, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateNotIn(List<Date> values) {
            addCriterion("opendate not in", values, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateBetween(Date value1, Date value2) {
            addCriterion("opendate between", value1, value2, "opendate");
            return (Criteria) this;
        }

        public Criteria andOpendateNotBetween(Date value1, Date value2) {
            addCriterion("opendate not between", value1, value2, "opendate");
            return (Criteria) this;
        }

        public Criteria andClosedateIsNull() {
            addCriterion("closedate is null");
            return (Criteria) this;
        }

        public Criteria andClosedateIsNotNull() {
            addCriterion("closedate is not null");
            return (Criteria) this;
        }

        public Criteria andClosedateEqualTo(Date value) {
            addCriterion("closedate =", value, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateNotEqualTo(Date value) {
            addCriterion("closedate <>", value, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateGreaterThan(Date value) {
            addCriterion("closedate >", value, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateGreaterThanOrEqualTo(Date value) {
            addCriterion("closedate >=", value, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateLessThan(Date value) {
            addCriterion("closedate <", value, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateLessThanOrEqualTo(Date value) {
            addCriterion("closedate <=", value, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateIn(List<Date> values) {
            addCriterion("closedate in", values, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateNotIn(List<Date> values) {
            addCriterion("closedate not in", values, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateBetween(Date value1, Date value2) {
            addCriterion("closedate between", value1, value2, "closedate");
            return (Criteria) this;
        }

        public Criteria andClosedateNotBetween(Date value1, Date value2) {
            addCriterion("closedate not between", value1, value2, "closedate");
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