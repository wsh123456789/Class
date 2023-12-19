package com.wsh.basics.inquirysheet.mapper;

import com.wsh.basics.inquirysheet.model.ShenHeVo;
import com.wsh.basics.inquirysheet.model.ShenPiVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InquiryAuditorMapper {
    @Update("update inquiry set status=3,auditorExplain=#{auditorExplain},auditorTime=#{auditorTime},auditorStatus=#{auditorStatus} where requestForQuotationId=#{requestForQuotationId}")
    void updateShenHe(ShenHeVo shenHeVo);

    @Select("select auditorStatus from inquiry where requestForQuotationId=#{requestForQuotationId}")
    Integer queryByOrderCode(String requestForQuotationId);

    @Select("select approverStatus from inquiry where requestForQuotationId=#{requestForQuotationId}")
    Integer queryByOrderCodeForApprover(String requestForQuotationId);

    @Update("update inquiry set status=4,approverExplain=#{approverExplain},approverTime=#{approverTime},approverStatus=#{approverStatus} where requestForQuotationId=#{requestForQuotationId}")
    void updateShenPi(ShenPiVo shenPiVo);

    @Select("select status from inquiry where requestForQuotationId=#{requestForQuotationId}")
    Integer queryStatus(String requestForQuotationId);
}
