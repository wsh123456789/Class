package com.wsh.dao;

import com.wsh.bean.CustomerCondition;
import com.wsh.bean.CustomerConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerConditionMapper {
    int countByExample(CustomerConditionExample example);

    int deleteByExample(CustomerConditionExample example);

    int deleteByPrimaryKey(Integer conditionId);

    int insert(CustomerCondition record);

    int insertSelective(CustomerCondition record);

    List<CustomerCondition> selectByExample(CustomerConditionExample example);

    CustomerCondition selectByPrimaryKey(Integer conditionId);

    int updateByExampleSelective(@Param("record") CustomerCondition record, @Param("example") CustomerConditionExample example);

    int updateByExample(@Param("record") CustomerCondition record, @Param("example") CustomerConditionExample example);

    int updateByPrimaryKeySelective(CustomerCondition record);

    int updateByPrimaryKey(CustomerCondition record);
}