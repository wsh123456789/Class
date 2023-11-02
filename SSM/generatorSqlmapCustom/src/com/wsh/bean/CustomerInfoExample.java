package com.wsh.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerInfoExample() {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
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

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Integer value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Integer value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Integer value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Integer value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Integer> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Integer> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
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

        public Criteria andCustomerQqIsNull() {
            addCriterion("customer_qq is null");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIsNotNull() {
            addCriterion("customer_qq is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerQqEqualTo(String value) {
            addCriterion("customer_qq =", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotEqualTo(String value) {
            addCriterion("customer_qq <>", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqGreaterThan(String value) {
            addCriterion("customer_qq >", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqGreaterThanOrEqualTo(String value) {
            addCriterion("customer_qq >=", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLessThan(String value) {
            addCriterion("customer_qq <", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLessThanOrEqualTo(String value) {
            addCriterion("customer_qq <=", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqLike(String value) {
            addCriterion("customer_qq like", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotLike(String value) {
            addCriterion("customer_qq not like", value, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqIn(List<String> values) {
            addCriterion("customer_qq in", values, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotIn(List<String> values) {
            addCriterion("customer_qq not in", values, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqBetween(String value1, String value2) {
            addCriterion("customer_qq between", value1, value2, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerQqNotBetween(String value1, String value2) {
            addCriterion("customer_qq not between", value1, value2, "customerQq");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNull() {
            addCriterion("customer_address is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNotNull() {
            addCriterion("customer_address is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressEqualTo(String value) {
            addCriterion("customer_address =", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotEqualTo(String value) {
            addCriterion("customer_address <>", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThan(String value) {
            addCriterion("customer_address >", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("customer_address >=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThan(String value) {
            addCriterion("customer_address <", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThanOrEqualTo(String value) {
            addCriterion("customer_address <=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLike(String value) {
            addCriterion("customer_address like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotLike(String value) {
            addCriterion("customer_address not like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIn(List<String> values) {
            addCriterion("customer_address in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotIn(List<String> values) {
            addCriterion("customer_address not in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressBetween(String value1, String value2) {
            addCriterion("customer_address between", value1, value2, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotBetween(String value1, String value2) {
            addCriterion("customer_address not between", value1, value2, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIsNull() {
            addCriterion("customer_email is null");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIsNotNull() {
            addCriterion("customer_email is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailEqualTo(String value) {
            addCriterion("customer_email =", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotEqualTo(String value) {
            addCriterion("customer_email <>", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailGreaterThan(String value) {
            addCriterion("customer_email >", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("customer_email >=", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLessThan(String value) {
            addCriterion("customer_email <", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLessThanOrEqualTo(String value) {
            addCriterion("customer_email <=", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailLike(String value) {
            addCriterion("customer_email like", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotLike(String value) {
            addCriterion("customer_email not like", value, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailIn(List<String> values) {
            addCriterion("customer_email in", values, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotIn(List<String> values) {
            addCriterion("customer_email not in", values, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailBetween(String value1, String value2) {
            addCriterion("customer_email between", value1, value2, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerEmailNotBetween(String value1, String value2) {
            addCriterion("customer_email not between", value1, value2, "customerEmail");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkIsNull() {
            addCriterion("customer_remark is null");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkIsNotNull() {
            addCriterion("customer_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkEqualTo(String value) {
            addCriterion("customer_remark =", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkNotEqualTo(String value) {
            addCriterion("customer_remark <>", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkGreaterThan(String value) {
            addCriterion("customer_remark >", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("customer_remark >=", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkLessThan(String value) {
            addCriterion("customer_remark <", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkLessThanOrEqualTo(String value) {
            addCriterion("customer_remark <=", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkLike(String value) {
            addCriterion("customer_remark like", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkNotLike(String value) {
            addCriterion("customer_remark not like", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkIn(List<String> values) {
            addCriterion("customer_remark in", values, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkNotIn(List<String> values) {
            addCriterion("customer_remark not in", values, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkBetween(String value1, String value2) {
            addCriterion("customer_remark between", value1, value2, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkNotBetween(String value1, String value2) {
            addCriterion("customer_remark not between", value1, value2, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerJobIsNull() {
            addCriterion("customer_job is null");
            return (Criteria) this;
        }

        public Criteria andCustomerJobIsNotNull() {
            addCriterion("customer_job is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerJobEqualTo(String value) {
            addCriterion("customer_job =", value, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobNotEqualTo(String value) {
            addCriterion("customer_job <>", value, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobGreaterThan(String value) {
            addCriterion("customer_job >", value, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobGreaterThanOrEqualTo(String value) {
            addCriterion("customer_job >=", value, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobLessThan(String value) {
            addCriterion("customer_job <", value, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobLessThanOrEqualTo(String value) {
            addCriterion("customer_job <=", value, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobLike(String value) {
            addCriterion("customer_job like", value, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobNotLike(String value) {
            addCriterion("customer_job not like", value, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobIn(List<String> values) {
            addCriterion("customer_job in", values, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobNotIn(List<String> values) {
            addCriterion("customer_job not in", values, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobBetween(String value1, String value2) {
            addCriterion("customer_job between", value1, value2, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerJobNotBetween(String value1, String value2) {
            addCriterion("customer_job not between", value1, value2, "customerJob");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogIsNull() {
            addCriterion("customer_blog is null");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogIsNotNull() {
            addCriterion("customer_blog is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogEqualTo(String value) {
            addCriterion("customer_blog =", value, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogNotEqualTo(String value) {
            addCriterion("customer_blog <>", value, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogGreaterThan(String value) {
            addCriterion("customer_blog >", value, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogGreaterThanOrEqualTo(String value) {
            addCriterion("customer_blog >=", value, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogLessThan(String value) {
            addCriterion("customer_blog <", value, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogLessThanOrEqualTo(String value) {
            addCriterion("customer_blog <=", value, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogLike(String value) {
            addCriterion("customer_blog like", value, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogNotLike(String value) {
            addCriterion("customer_blog not like", value, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogIn(List<String> values) {
            addCriterion("customer_blog in", values, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogNotIn(List<String> values) {
            addCriterion("customer_blog not in", values, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogBetween(String value1, String value2) {
            addCriterion("customer_blog between", value1, value2, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerBlogNotBetween(String value1, String value2) {
            addCriterion("customer_blog not between", value1, value2, "customerBlog");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIsNull() {
            addCriterion("customer_tel is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIsNotNull() {
            addCriterion("customer_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTelEqualTo(String value) {
            addCriterion("customer_tel =", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotEqualTo(String value) {
            addCriterion("customer_tel <>", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelGreaterThan(String value) {
            addCriterion("customer_tel >", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelGreaterThanOrEqualTo(String value) {
            addCriterion("customer_tel >=", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLessThan(String value) {
            addCriterion("customer_tel <", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLessThanOrEqualTo(String value) {
            addCriterion("customer_tel <=", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLike(String value) {
            addCriterion("customer_tel like", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotLike(String value) {
            addCriterion("customer_tel not like", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIn(List<String> values) {
            addCriterion("customer_tel in", values, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotIn(List<String> values) {
            addCriterion("customer_tel not in", values, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelBetween(String value1, String value2) {
            addCriterion("customer_tel between", value1, value2, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotBetween(String value1, String value2) {
            addCriterion("customer_tel not between", value1, value2, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnIsNull() {
            addCriterion("customer_msn is null");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnIsNotNull() {
            addCriterion("customer_msn is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnEqualTo(String value) {
            addCriterion("customer_msn =", value, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnNotEqualTo(String value) {
            addCriterion("customer_msn <>", value, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnGreaterThan(String value) {
            addCriterion("customer_msn >", value, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnGreaterThanOrEqualTo(String value) {
            addCriterion("customer_msn >=", value, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnLessThan(String value) {
            addCriterion("customer_msn <", value, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnLessThanOrEqualTo(String value) {
            addCriterion("customer_msn <=", value, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnLike(String value) {
            addCriterion("customer_msn like", value, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnNotLike(String value) {
            addCriterion("customer_msn not like", value, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnIn(List<String> values) {
            addCriterion("customer_msn in", values, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnNotIn(List<String> values) {
            addCriterion("customer_msn not in", values, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnBetween(String value1, String value2) {
            addCriterion("customer_msn between", value1, value2, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andCustomerMsnNotBetween(String value1, String value2) {
            addCriterion("customer_msn not between", value1, value2, "customerMsn");
            return (Criteria) this;
        }

        public Criteria andBirthDayIsNull() {
            addCriterion("birth_day is null");
            return (Criteria) this;
        }

        public Criteria andBirthDayIsNotNull() {
            addCriterion("birth_day is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDayEqualTo(Date value) {
            addCriterion("birth_day =", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayNotEqualTo(Date value) {
            addCriterion("birth_day <>", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayGreaterThan(Date value) {
            addCriterion("birth_day >", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayGreaterThanOrEqualTo(Date value) {
            addCriterion("birth_day >=", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayLessThan(Date value) {
            addCriterion("birth_day <", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayLessThanOrEqualTo(Date value) {
            addCriterion("birth_day <=", value, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayIn(List<Date> values) {
            addCriterion("birth_day in", values, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayNotIn(List<Date> values) {
            addCriterion("birth_day not in", values, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayBetween(Date value1, Date value2) {
            addCriterion("birth_day between", value1, value2, "birthDay");
            return (Criteria) this;
        }

        public Criteria andBirthDayNotBetween(Date value1, Date value2) {
            addCriterion("birth_day not between", value1, value2, "birthDay");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeIsNull() {
            addCriterion("customer_addtime is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeIsNotNull() {
            addCriterion("customer_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeEqualTo(Date value) {
            addCriterion("customer_addtime =", value, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeNotEqualTo(Date value) {
            addCriterion("customer_addtime <>", value, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeGreaterThan(Date value) {
            addCriterion("customer_addtime >", value, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("customer_addtime >=", value, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeLessThan(Date value) {
            addCriterion("customer_addtime <", value, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("customer_addtime <=", value, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeIn(List<Date> values) {
            addCriterion("customer_addtime in", values, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeNotIn(List<Date> values) {
            addCriterion("customer_addtime not in", values, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeBetween(Date value1, Date value2) {
            addCriterion("customer_addtime between", value1, value2, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("customer_addtime not between", value1, value2, "customerAddtime");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanIsNull() {
            addCriterion("customer_addman is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanIsNotNull() {
            addCriterion("customer_addman is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanEqualTo(String value) {
            addCriterion("customer_addman =", value, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanNotEqualTo(String value) {
            addCriterion("customer_addman <>", value, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanGreaterThan(String value) {
            addCriterion("customer_addman >", value, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanGreaterThanOrEqualTo(String value) {
            addCriterion("customer_addman >=", value, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanLessThan(String value) {
            addCriterion("customer_addman <", value, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanLessThanOrEqualTo(String value) {
            addCriterion("customer_addman <=", value, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanLike(String value) {
            addCriterion("customer_addman like", value, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanNotLike(String value) {
            addCriterion("customer_addman not like", value, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanIn(List<String> values) {
            addCriterion("customer_addman in", values, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanNotIn(List<String> values) {
            addCriterion("customer_addman not in", values, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanBetween(String value1, String value2) {
            addCriterion("customer_addman between", value1, value2, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerAddmanNotBetween(String value1, String value2) {
            addCriterion("customer_addman not between", value1, value2, "customerAddman");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeIsNull() {
            addCriterion("customer_changtime is null");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeIsNotNull() {
            addCriterion("customer_changtime is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeEqualTo(Date value) {
            addCriterion("customer_changtime =", value, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeNotEqualTo(Date value) {
            addCriterion("customer_changtime <>", value, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeGreaterThan(Date value) {
            addCriterion("customer_changtime >", value, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("customer_changtime >=", value, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeLessThan(Date value) {
            addCriterion("customer_changtime <", value, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeLessThanOrEqualTo(Date value) {
            addCriterion("customer_changtime <=", value, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeIn(List<Date> values) {
            addCriterion("customer_changtime in", values, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeNotIn(List<Date> values) {
            addCriterion("customer_changtime not in", values, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeBetween(Date value1, Date value2) {
            addCriterion("customer_changtime between", value1, value2, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andCustomerChangtimeNotBetween(Date value1, Date value2) {
            addCriterion("customer_changtime not between", value1, value2, "customerChangtime");
            return (Criteria) this;
        }

        public Criteria andChangeManIsNull() {
            addCriterion("change_man is null");
            return (Criteria) this;
        }

        public Criteria andChangeManIsNotNull() {
            addCriterion("change_man is not null");
            return (Criteria) this;
        }

        public Criteria andChangeManEqualTo(String value) {
            addCriterion("change_man =", value, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManNotEqualTo(String value) {
            addCriterion("change_man <>", value, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManGreaterThan(String value) {
            addCriterion("change_man >", value, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManGreaterThanOrEqualTo(String value) {
            addCriterion("change_man >=", value, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManLessThan(String value) {
            addCriterion("change_man <", value, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManLessThanOrEqualTo(String value) {
            addCriterion("change_man <=", value, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManLike(String value) {
            addCriterion("change_man like", value, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManNotLike(String value) {
            addCriterion("change_man not like", value, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManIn(List<String> values) {
            addCriterion("change_man in", values, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManNotIn(List<String> values) {
            addCriterion("change_man not in", values, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManBetween(String value1, String value2) {
            addCriterion("change_man between", value1, value2, "changeMan");
            return (Criteria) this;
        }

        public Criteria andChangeManNotBetween(String value1, String value2) {
            addCriterion("change_man not between", value1, value2, "changeMan");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIsNull() {
            addCriterion("customer_company is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIsNotNull() {
            addCriterion("customer_company is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyEqualTo(String value) {
            addCriterion("customer_company =", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotEqualTo(String value) {
            addCriterion("customer_company <>", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyGreaterThan(String value) {
            addCriterion("customer_company >", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("customer_company >=", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLessThan(String value) {
            addCriterion("customer_company <", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLessThanOrEqualTo(String value) {
            addCriterion("customer_company <=", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyLike(String value) {
            addCriterion("customer_company like", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotLike(String value) {
            addCriterion("customer_company not like", value, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyIn(List<String> values) {
            addCriterion("customer_company in", values, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotIn(List<String> values) {
            addCriterion("customer_company not in", values, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyBetween(String value1, String value2) {
            addCriterion("customer_company between", value1, value2, "customerCompany");
            return (Criteria) this;
        }

        public Criteria andCustomerCompanyNotBetween(String value1, String value2) {
            addCriterion("customer_company not between", value1, value2, "customerCompany");
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