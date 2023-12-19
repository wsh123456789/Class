package com.wsh.purchaser.mapper;

import com.wsh.model.AddVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PurchaserMapper {
    @Select("select count(id) from order_purchaser where orderCode = #{orderCode}")
    int queryOrderByCode(AddVo addVo);

    @Insert("insert into order_purchaser(orderCode,address,purchaser,status,createTime) values(#{orderCode},#{address},#{purchaser},#{status},#{createTime})")
    void add(AddVo addVo);

    void addCount(AddVo addVo);

    void check(AddVo addvo);

    @Update("update order_purchaser set mqStatus=#{mqStatus} where orderCode=#{orderCode}")
    void updateMQStatus(@Param("orderCode") String orderCode, @Param("mqStatus")int mqStatus);


    @Select("select mqStatus from order_purchaser where orderCode=#{orderCode} and status=2")
    Integer queryMQStatusByCodeAndStatus(AddVo addVo);
}
