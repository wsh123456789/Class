package com.chen.order.mapper;

import com.chen.order.entiy.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface OrderMapper {

    @Select("select id,price,name,num,user_id userId from orderInfo where id =#{id}")
    Order findById(int id);
}
