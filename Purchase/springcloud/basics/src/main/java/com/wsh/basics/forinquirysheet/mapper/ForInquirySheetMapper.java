package com.wsh.basics.forinquirysheet.mapper;

import com.wsh.basics.forinquirysheet.model.CreateInquirySheetAddVo;
import com.wsh.basics.forinquirysheet.model.CreateInquirySheetSelectVo;
import com.wsh.basics.forinquirysheet.model.CreateInquirySheetVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ForInquirySheetMapper {

    @Select("select count(legalPersonCode) from legalperson where legalPersonCode=#{legalPersonCode}")
    Integer queryLegalCode(CreateInquirySheetAddVo createInquirySheetAddVo);

    List<String> queryCodeList(@Param("codeList") List<String> codeList);

    List<String> querySupplierCodeList(List<String> supplierList);

    List<String> querySpareForSupplier(@Param("codeList")List<String> codeList);

    List<String> querySupplierForSpare(@Param("codeList")List<String> freeSupplier);

    List<CreateInquirySheetVo> selectMaterial(CreateInquirySheetSelectVo createInquirySheetSelectVo);

    int queryReplacementCount(CreateInquirySheetSelectVo createInquirySheetSelectVo);
}
