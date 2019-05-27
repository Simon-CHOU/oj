package com.simon.oj.pojo;

import java.util.ArrayList;
import java.util.List;

public class ApExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApExample() {
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