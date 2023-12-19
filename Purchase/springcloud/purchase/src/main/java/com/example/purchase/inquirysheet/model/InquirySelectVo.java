package com.example.purchase.inquirysheet.model;

import com.example.purchase.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class InquirySelectVo extends PageVo {
    // 类型
    private String type;
    //询价单号
    private String requestForQuotationId;
    //询价开始时间
    private Date startTime;
    //询价结束时间
    private Date endTime;
    // 询价状态
    private Integer inquiryStatus;
    // 询价人
    private String createName;
    // 询价时间
    private Date createTime;
    // 修改人
    private String changeName;
    // 修改时间
    private Date changeTime;
    // 版本号
    private Integer version;
    // 法人id
    private Integer legalPersonId;
    // 法人姓名
    private String legalPersonName;
    // 创建开始时间
    private Date createStartTime;
    // 创建结束时间
    private Date createEndTime;
    // 状态名
    private String inquiryStatusName;
   // 供应商编码
   private String supplierCode;

}
