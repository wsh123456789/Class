package com.example.purchase.inquirysheet.mapper;

import com.example.purchase.inquirysheet.model.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InquirySheetMapper {

    List<CreateInquirySheetVo> selectMaterial(CreateInquirySheetSelectVo createInquirySheetSelectVo);

    int queryCount(InquirySelectVo createInquirySheetSelectVo);

    List<InquirySelectVo> queryData(InquirySelectVo inquirySelectVo);

    int queryReplacementCount(CreateInquirySheetSelectVo createInquirySheetSelectVo);

    int queryStatus(String requestForQuotationId);

    void modifyState(String requestForQuotationId);

    
    List<String> queryCodeList(@Param("codeList") List<String> codeList);

    List<String> querySupplierCodeList(@Param("codeList")List<String> codeList);

    List<String> querySpareForSupplier(@Param("codeList")List<String> codeList);

    List<String> querySupplierForSpare(@Param("codeList")List<String> freeSupplier);

    void add(CreateInquirySheetVo createInquirySheetAddVo);

    @Select("select count(id) from inquiry where requestForQuotationId=#{orderCode}")
    int queryOrderCode(String orderCode);

    void addForSpare(CreateInquirySheetVo createInquirySheetVo);

    void addForSupplier(CreateInquirySheetVo createInquirySheetVo);

    SeeVo querySeeData(String requestForQuotationId);

    List<InquiryDetails> querySeeInquiryData(String requestForQuotationId);

    List<SupplierDetails> querySeeSupplierData(String requestForQuotationId);

    void update(CreateInquirySheetVo createInquirySheetVo);

    @Delete("DELETE FROM inquiry_replacement where requestForQuotationId=#{requestForQuotationId}")
    void deleteForSpare(CreateInquirySheetVo createInquirySheetVo);
    @Delete("DELETE FROM inquiry_supplier where requestForQuotationId=#{requestForQuotationId}")
    void deleteForSupplier(CreateInquirySheetVo createInquirySheetVo);

//    @Select("select count(id) from type where type=#{type}")
//    int queryType(CreateInquirySheetAddVo createInquirySheetAddVo);
}
