package com.wsh.springboot.supplier.mapper;

import com.wsh.springboot.common.model.LegalPersonVo;
import com.wsh.springboot.supplier.model.SupplierSelectVo;
import com.wsh.springboot.supplier.model.SupplierVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SupplierMapper {

    List<SupplierVo> searchPartnerPage(SupplierSelectVo supplierSelectVo);

    int queryCount(SupplierSelectVo supplierSelectVo);

    @Select("select s.code partnerCode,s.name partnerName from supplier s left join legal_supplier ls on s.code=ls.supplierCode left join legalperson l on l.id=ls.legalpersonId where l.id=#{legalPersonId}")
    List<SupplierVo> queryByLegalPerson(Integer legalPersonId);
}
