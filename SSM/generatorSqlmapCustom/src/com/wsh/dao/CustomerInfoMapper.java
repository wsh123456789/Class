package com.wsh.dao;

import com.wsh.bean.CustomerInfo;
import com.wsh.bean.CustomerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoMapper {
    int countByExample(CustomerInfoExample example);

    int deleteByExample(CustomerInfoExample example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(CustomerInfo record);

    int insertSelective(CustomerInfo record);

    List<CustomerInfo> selectByExample(CustomerInfoExample example);

    CustomerInfo selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    int updateByExample(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);
}