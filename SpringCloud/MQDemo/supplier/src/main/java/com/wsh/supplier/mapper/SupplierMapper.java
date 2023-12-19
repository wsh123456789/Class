package com.wsh.supplier.mapper;

import com.wsh.model.AddVo;
import com.wsh.model.OrderVo;
import com.wsh.model.OutTimeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplierMapper {

    List<OrderVo> queryInventory(AddVo addVo);

    void updateInventory(@Param("spares") List<OrderVo> spares);

    void deleteByCode(AddVo addVo);

    @Insert("insert into order_supplier(orderCode,address,purchaser,createTime) values(#{orderCode},#{address},#{purchaser},#{createTime})")
    void add(AddVo addVo);

    void addCount(AddVo addVo);

    void subInventory(AddVo addVo);

    List<OutTimeVo> queryOutTime(long createTime);

    void free(@Param("outTimeVos") List<OutTimeVo> outTimeVos);
}
