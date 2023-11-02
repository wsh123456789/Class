package com.wsh.bean;

import java.util.ArrayList;
import java.util.List;

public class CustomerConditionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerConditionExample() {
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

        public Criteria andConditionIdIsNull() {
            addCriterion("condition_id is null");
            return (Criteria) this;
        }

        public Criteria andConditionIdIsNotNull() {
            addCriterion("condition_id is not null");
            return (Criteria) this;
        }

        public Criteria andConditionIdEqualTo(Integer value) {
            addCriterion("condition_id =", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdNotEqualTo(Integer value) {
            addCriterion("condition_id <>", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdGreaterThan(Integer value) {
            addCriterion("condition_id >", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("condition_id >=", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdLessThan(Integer value) {
            addCriterion("condition_id <", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdLessThanOrEqualTo(Integer value) {
            addCriterion("condition_id <=", value, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdIn(List<Integer> values) {
            addCriterion("condition_id in", values, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdNotIn(List<Integer> values) {
            addCriterion("condition_id not in", values, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdBetween(Integer value1, Integer value2) {
            addCriterion("condition_id between", value1, value2, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("condition_id not between", value1, value2, "conditionId");
            return (Criteria) this;
        }

        public Criteria andConditionNameIsNull() {
            addCriterion("condition_name is null");
            return (Criteria) this;
        }

        public Criteria andConditionNameIsNotNull() {
            addCriterion("condition_name is not null");
            return (Criteria) this;
        }

        public Criteria andConditionNameEqualTo(String value) {
            addCriterion("condition_name =", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameNotEqualTo(String value) {
            addCriterion("condition_name <>", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameGreaterThan(String value) {
            addCriterion("condition_name >", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameGreaterThanOrEqualTo(String value) {
            addCriterion("condition_name >=", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameLessThan(String value) {
            addCriterion("condition_name <", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameLessThanOrEqualTo(String value) {
            addCriterion("condition_name <=", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameLike(String value) {
            addCriterion("condition_name like", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameNotLike(String value) {
            addCriterion("condition_name not like", value, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameIn(List<String> values) {
            addCriterion("condition_name in", values, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameNotIn(List<String> values) {
            addCriterion("condition_name not in", values, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameBetween(String value1, String value2) {
            addCriterion("condition_name between", value1, value2, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionNameNotBetween(String value1, String value2) {
            addCriterion("condition_name not between", value1, value2, "conditionName");
            return (Criteria) this;
        }

        public Criteria andConditionExplainIsNull() {
            addCriterion("condition_explain is null");
            return (Criteria) this;
        }

        public Criteria andConditionExplainIsNotNull() {
            addCriterion("condition_explain is not null");
            return (Criteria) this;
        }

        public Criteria andConditionExplainEqualTo(String value) {
            addCriterion("condition_explain =", value, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainNotEqualTo(String value) {
            addCriterion("condition_explain <>", value, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainGreaterThan(String value) {
            addCriterion("condition_explain >", value, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainGreaterThanOrEqualTo(String value) {
            addCriterion("condition_explain >=", value, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainLessThan(String value) {
            addCriterion("condition_explain <", value, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainLessThanOrEqualTo(String value) {
            addCriterion("condition_explain <=", value, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainLike(String value) {
            addCriterion("condition_explain like", value, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainNotLike(String value) {
            addCriterion("condition_explain not like", value, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainIn(List<String> values) {
            addCriterion("condition_explain in", values, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainNotIn(List<String> values) {
            addCriterion("condition_explain not in", values, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainBetween(String value1, String value2) {
            addCriterion("condition_explain between", value1, value2, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andConditionExplainNotBetween(String value1, String value2) {
            addCriterion("condition_explain not between", value1, value2, "conditionExplain");
            return (Criteria) this;
        }

        public Criteria andIsUsedIsNull() {
            addCriterion("is_used is null");
            return (Criteria) this;
        }

        public Criteria andIsUsedIsNotNull() {
            addCriterion("is_used is not null");
            return (Criteria) this;
        }

        public Criteria andIsUsedEqualTo(String value) {
            addCriterion("is_used =", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotEqualTo(String value) {
            addCriterion("is_used <>", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThan(String value) {
            addCriterion("is_used >", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThanOrEqualTo(String value) {
            addCriterion("is_used >=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThan(String value) {
            addCriterion("is_used <", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThanOrEqualTo(String value) {
            addCriterion("is_used <=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLike(String value) {
            addCriterion("is_used like", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotLike(String value) {
            addCriterion("is_used not like", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedIn(List<String> values) {
            addCriterion("is_used in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotIn(List<String> values) {
            addCriterion("is_used not in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedBetween(String value1, String value2) {
            addCriterion("is_used between", value1, value2, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotBetween(String value1, String value2) {
            addCriterion("is_used not between", value1, value2, "isUsed");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIsNull() {
            addCriterion("customer_sex is null");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIsNotNull() {
            addCriterion("customer_sex is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerSexEqualTo(String value) {
            addCriterion("customer_sex =", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotEqualTo(String value) {
            addCriterion("customer_sex <>", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexGreaterThan(String value) {
            addCriterion("customer_sex >", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexGreaterThanOrEqualTo(String value) {
            addCriterion("customer_sex >=", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLessThan(String value) {
            addCriterion("customer_sex <", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLessThanOrEqualTo(String value) {
            addCriterion("customer_sex <=", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexLike(String value) {
            addCriterion("customer_sex like", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotLike(String value) {
            addCriterion("customer_sex not like", value, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexIn(List<String> values) {
            addCriterion("customer_sex in", values, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotIn(List<String> values) {
            addCriterion("customer_sex not in", values, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexBetween(String value1, String value2) {
            addCriterion("customer_sex between", value1, value2, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerSexNotBetween(String value1, String value2) {
            addCriterion("customer_sex not between", value1, value2, "customerSex");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileIsNull() {
            addCriterion("customer_mobile is null");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileIsNotNull() {
            addCriterion("customer_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileEqualTo(String value) {
            addCriterion("customer_mobile =", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileNotEqualTo(String value) {
            addCriterion("customer_mobile <>", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileGreaterThan(String value) {
            addCriterion("customer_mobile >", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileGreaterThanOrEqualTo(String value) {
            addCriterion("customer_mobile >=", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileLessThan(String value) {
            addCriterion("customer_mobile <", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileLessThanOrEqualTo(String value) {
            addCriterion("customer_mobile <=", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileLike(String value) {
            addCriterion("customer_mobile like", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileNotLike(String value) {
            addCriterion("customer_mobile not like", value, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileIn(List<String> values) {
            addCriterion("customer_mobile in", values, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileNotIn(List<String> values) {
            addCriterion("customer_mobile not in", values, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileBetween(String value1, String value2) {
            addCriterion("customer_mobile between", value1, value2, "customerMobile");
            return (Criteria) this;
        }

        public Criteria andCustomerMobileNotBetween(String value1, String value2) {
            addCriterion("customer_mobile not between", value1, value2, "customerMobile");
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