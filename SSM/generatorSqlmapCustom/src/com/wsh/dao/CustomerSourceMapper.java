package com.wsh.dao;

import com.wsh.bean.CustomerSource;
import com.wsh.bean.CustomerSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerSourceMapper {
    int countByExample(CustomerSourceExample example);

    int deleteByExample(CustomerSourceExample example);

    int deleteByPrimaryKey(Integer sourceId);

    int insert(CustomerSource record);

    int insertSelective(CustomerSource record);

    List<CustomerSource> selectByExample(CustomerSourceExample example);

    CustomerSource selectByPrimaryKey(Integer sourceId);

    int updateByExampleSelective(@Param("record") CustomerSource record, @Param("example") CustomerSourceExample example);

    int updateByExample(@Param("record") CustomerSource record, @Param("example") CustomerSourceExample example);

    int updateByPrimaryKeySelective(CustomerSource record);

    int updateByPrimaryKey(CustomerSource record);
}