package com.wsh.springboot.inquirysheet.service.impl;

import com.wsh.springboot.inquirysheet.mapper.InquiryAuditorMapper;
import com.wsh.springboot.inquirysheet.model.InquirySelectVo;
import com.wsh.springboot.inquirysheet.model.ShenHeVo;
import com.wsh.springboot.inquirysheet.model.ShenPiVo;
import com.wsh.springboot.inquirysheet.service.InquiryAuditorService;
import com.wsh.springboot.util.ParamUtil;
import com.wsh.springboot.util.ResultBuildVo;
import com.wsh.springboot.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryAuditorServiceImpl implements InquiryAuditorService {
    @Autowired
    private InquiryAuditorMapper inquiryAuditorMapper;
    @Override
    public ResultVo updateShenHe(ShenHeVo shenHeVo) {
        // 查询订单是否存在,验证订单是否已提交并验证是否已经审核过
        Integer status = inquiryAuditorMapper.queryStatus(shenHeVo.getRequestForQuotationId());
        //
        Integer auditorStatus = inquiryAuditorMapper.queryByOrderCode(shenHeVo.getRequestForQuotationId());
        if (auditorStatus == null){
            ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        }
        else if (status != 2){
            ResultBuildVo.error(ParamUtil.INQUIRY_NOT_SUBMIT);
        }else if (auditorStatus == 1) {
            ResultBuildVo.error(ParamUtil.AUDITOR_STATUS_REPEAT);
        }
        inquiryAuditorMapper.updateShenHe(shenHeVo);
        return ResultBuildVo.success();
    }

    @Override
    public ResultVo searchShenPi(ShenPiVo shenPiVo) {
        // 查询订单是否存在并验证是否已经审核过
        Integer auditorStatus = inquiryAuditorMapper.queryByOrderCode(shenPiVo.getRequestForQuotationId());
        if (auditorStatus == null){
            ResultBuildVo.error(ParamUtil.UPDATE_MESSAGE_NOTFOUND);
        } else if (auditorStatus == 1) {
            ResultBuildVo.error(ParamUtil.AUDITOR_STATUS_REPEAT);
        }
        // 验证是否审批过
        Integer approverStatus = inquiryAuditorMapper.queryByOrderCodeForApprover(shenPiVo.getRequestForQuotationId());
        if (approverStatus == 1){
            ResultBuildVo.error(ParamUtil.APPROVER_STATUS_REPEAT);
        }
        // 修改状态
        inquiryAuditorMapper.updateShenPi(shenPiVo);
        return ResultBuildVo.success();
    }
}
