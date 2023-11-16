package com.wsh.springboot.common.mapper;

import com.wsh.springboot.common.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommonMapper {
    @Select("select l.id legalPersonId,l.legalPersonCode,l.legalPersonName from legalperson l left join legalperson_user lu on l.id = lu.legalPersonId where lu.userId = #{id}")
    List<LegalPersonVo> queryLegalPersonListById(Integer id);

    @Select("select DISTINCT r.replacementCode,r.replacementName from legalperson l " +
            "LEFT JOIN  legal_replacement lr ON l.legalPersonCode = lr.legalpersonCode " +
            "LEFT JOIN replacement r " +
            "ON r.replacementCode = lr.replacementCode " +
            "WHERE l.legalPersonCode=#{legalPersonCode}")
    List<ReplacementVo> getReplacementListByCode(String legalPersonCode);

    @Select("select subclassName from replacement where replacementCode=#{replacementCode}")
    List<SubclassVo> getSubclassListByCode(String replacementCode);

    @Select("select code,name,remark from warehouse")
    List<WareHouseVo> queryWareHouse();
    @Select("select code,name,remark from storagesection where wareHouseCode=#{code}")
    List<WareHouseAreaVo> queryStorageSection(String code);
}
