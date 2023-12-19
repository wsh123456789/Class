package com.wsh.basics.inquirysheet.service.impl;

import com.wsh.basics.enumpackage.CurrencyEnum;
import com.wsh.basics.enumpackage.TaxEnum;
import com.wsh.basics.enumpackage.TypeEnum;
import com.wsh.basics.inquirysheet.mapper.InquirySheetMapper;
import com.wsh.basics.inquirysheet.service.InquirySheetService;
import com.wsh.basics.util.AllRecordsVo;
import com.wsh.basics.util.ParamUtil;
import com.wsh.basics.util.ResultBuildVo;
import com.wsh.basics.util.ResultVo;
import com.wsh.basics.inquirysheet.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class InquirySheetServiceImpl implements InquirySheetService {

    @Autowired
    private InquirySheetMapper inquirySheetMapper;

    /**
     * 备件查询
     */
    @Override
    public ResultVo selectMaterial(CreateInquirySheetSelectVo createInquirySheetSelectVo) {
        List<CreateInquirySheetVo> createInquirySheetVos = inquirySheetMapper.selectMaterial(createInquirySheetSelectVo);

        int count = inquirySheetMapper.queryReplacementCount(createInquirySheetSelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(createInquirySheetSelectVo.getPageIndex());
        allRecordsVo.setPageSize(createInquirySheetSelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(createInquirySheetVos);
        return ResultBuildVo.success(allRecordsVo);
    }

    /**
     * 主界面查询
     */
    @Override
    public ResultVo search(InquirySelectVo inquirySelectVo) {
        //查询数据
        List<InquirySelectVo> inquiryVoList = inquirySheetMapper.queryData(inquirySelectVo);
        for (InquirySelectVo inquiryVo:inquiryVoList){
            if (inquiryVo.getInquiryStatus() == ParamUtil.ZERO){
                inquiryVo.setInquiryStatusName(ParamUtil.VOIDED);
            }
            if (inquiryVo.getInquiryStatus() == ParamUtil.ONE){
                inquiryVo.setInquiryStatusName(ParamUtil.SAVED);
            }
            if (inquiryVo.getInquiryStatus() == ParamUtil.TWO){
                inquiryVo.setInquiryStatusName(ParamUtil.SUBMITTED);
            }
            if (inquiryVo.getInquiryStatus() == ParamUtil.THREE){
                inquiryVo.setInquiryStatusName(ParamUtil.AUDITED);
            }
            if (inquiryVo.getInquiryStatus() == ParamUtil.FOUR){
                inquiryVo.setInquiryStatusName(ParamUtil.NOT_QUOTE);
            }
        }
        //查询数量
        int count = inquirySheetMapper.queryCount(inquirySelectVo);
        AllRecordsVo allRecordsVo = new AllRecordsVo();
        allRecordsVo.setPageIndex(inquirySelectVo.getPageIndex());
        allRecordsVo.setPageSize(inquirySelectVo.getPageSize());
        allRecordsVo.setTotalNumber(count);
        allRecordsVo.setTotalPage(allRecordsVo.countPage(count));
        allRecordsVo.setDataList(inquiryVoList);
        return ResultBuildVo.success(allRecordsVo);
    }

    /**
     * 作废
     */
    @Override
    public ResultVo modifyState(ModifyState modifyState) {
        //验证是否是已作废
        int count = inquirySheetMapper.queryStatus(modifyState.getRequestForQuotationId());

        if (count == 0) {
            return ResultBuildVo.error(ParamUtil.ORDER_FROM + ParamUtil.VOIDED);
        }
        inquirySheetMapper.modifyState(modifyState.getRequestForQuotationId());

        return ResultBuildVo.success();
    }

    /**
     * 新增
     */
    @Override
    @Transactional
    public ResultVo add(CreateInquirySheetAddVo createInquirySheetAddVo) {
        // 1.验证法人编码是否存在
        int legalCount = inquirySheetMapper.queryLegalCode(createInquirySheetAddVo);
        if (legalCount == 0) {
            return ResultBuildVo.error(ParamUtil.LEGAL_PERSON + ParamUtil.NOT_FOUNT);
        }
        // 验证是否存在，以及时间，数量是否合法
        ResultVo flag1 = getResultVo(createInquirySheetAddVo);
        if (flag1 != null) return flag1;
        // 验证是否重复,是否存在
        ResultVo flag2 = getListResultVo(createInquirySheetAddVo);
        if (flag2 != null) return flag2;

        while (true){
            // 生成订单号
            String orderCode = randomOrderCode(createInquirySheetAddVo.getCreateTime());
            // 验证生成的订单号是否存在
            int count = inquirySheetMapper.queryOrderCode(orderCode);
            if (count == 0){
                createInquirySheetAddVo.setRequestForQuotationId(orderCode);
                break;
            }
        }

        CreateInquirySheetVo createInquirySheetVo = new CreateInquirySheetVo();
        BeanUtils.copyProperties(createInquirySheetAddVo,createInquirySheetVo);
        // 从session中拿修改人
        createInquirySheetVo.setCreateName(ParamUtil.CHANGE_MAN);
        createInquirySheetVo.setChangeTime(new Date());
        createInquirySheetVo.setChangeName(ParamUtil.CHANGE_MAN);
        // 把基本数据添加到订单表
        inquirySheetMapper.add(createInquirySheetVo);
        // 添加与备件的联系
        inquirySheetMapper.addForSpare(createInquirySheetVo);
        // 添加与供应商的联系
        inquirySheetMapper.addForSupplier(createInquirySheetVo);
        return ResultBuildVo.success();
    }

    /**
     * 查看功能
     */
    @Override
    public ResultVo see(String requestForQuotationId) {
        //查询数据
        SeeVo seeVo = inquirySheetMapper.querySeeData(requestForQuotationId);
        seeVo.setInquiryDetailsList(inquirySheetMapper.querySeeInquiryData(requestForQuotationId));
        seeVo.setSupplierDetailsList(inquirySheetMapper.querySeeSupplierData(requestForQuotationId));
        return ResultBuildVo.success(seeVo);
    }


    /**
     * 修改功能
     */
    @Override
    @Transactional
    public ResultVo update(CreateInquirySheetAddVo createInquirySheetAddVo) {
        // 1.验证法人编码是否存在
        int legalCount = inquirySheetMapper.queryLegalCode(createInquirySheetAddVo);
        if (legalCount == 0) {
            return ResultBuildVo.error(ParamUtil.LEGAL_PERSON + ParamUtil.NOT_FOUNT);
        }
        // 验证是否存在，以及时间，数量是否合法
        ResultVo flag1 = getResultVo(createInquirySheetAddVo);
        if (flag1 != null) return flag1;
        // 验证是否重复,是否存在
        ResultVo flag2 = getListResultVo(createInquirySheetAddVo);
        if (flag2 != null) return flag2;

        CreateInquirySheetVo createInquirySheetVo = new CreateInquirySheetVo();
        BeanUtils.copyProperties(createInquirySheetAddVo,createInquirySheetVo);
        // 从session中拿修改人
        createInquirySheetVo.setCreateName(ParamUtil.CHANGE_MAN);
        createInquirySheetVo.setChangeTime(new Date());
        createInquirySheetVo.setChangeName(ParamUtil.CHANGE_MAN);
        // 修改基本数据
        inquirySheetMapper.update(createInquirySheetVo);
        // 删除之前备件的联系
        inquirySheetMapper.deleteForSpare(createInquirySheetVo);
        // 添加与备件的联系
        inquirySheetMapper.addForSpare(createInquirySheetVo);
        // 删除之前的供应商关系
        inquirySheetMapper.deleteForSupplier(createInquirySheetVo);
        // 添加与供应商的联系
        inquirySheetMapper.addForSupplier(createInquirySheetVo);
        return ResultBuildVo.success();
    }

    /**
     * 验证备件和供应商的存在情况
     */
    private ResultVo getListResultVo(CreateInquirySheetAddVo createInquirySheetAddVo) {
        // 验证备件是否重复
        List<String> codeList = new ArrayList<>();
        for (InquiryDetails inquiryDetails : createInquirySheetAddVo.getInquiryDetailsList()) {
            String code = inquiryDetails.getSpareCoding();
            if (codeList.contains(code)) {
                return ResultBuildVo.error(code + ParamUtil.REPLACEMENT_REPEAT);
            }
            codeList.add(code);
        }
        // 验证供应商是否重复
        List<String> supplierList = new ArrayList<>();
        for (SupplierDetails supplierDetails : createInquirySheetAddVo.getSupplierDetailsList()) {
            String code = supplierDetails.getVendorCode();
            if (supplierList.contains(code)) {
                return ResultBuildVo.error(code + ParamUtil.REPLACEMENT_REPEAT);
            }
            supplierList.add(code);
        }
        // 验证备件是否存在
        List<String> newCodeList = inquirySheetMapper.queryCodeList(codeList);
        if (newCodeList.size() != codeList.size()) {
           codeList.removeAll(newCodeList);
           return ResultBuildVo.error(ParamUtil.REPLACEMENT + codeList.toString() + ParamUtil.NOT_FOUNT);
        }
        // 验证供应商是否存在
        List<String> newSupplierList = inquirySheetMapper.querySupplierCodeList(supplierList);
        if (newSupplierList.size() != supplierList.size()) {
            supplierList.removeAll(newSupplierList);
            return ResultBuildVo.error(ParamUtil.REPLACEMENT + supplierList.toString() + ParamUtil.NOT_FOUNT);
        }
        // 验证备件和供应商的空闲情况
        ResultVo flag = judgeFree(codeList, supplierList);
        if (flag != null) return flag;
        return null;
    }

    /**
     * 验证备件和供应商的空闲情况
     */
    private ResultVo judgeFree(List<String> codeList, List<String> supplierList) {
        // 获取备件对应的供应商
        List<String> spareForSupplier = inquirySheetMapper.querySpareForSupplier(codeList);
        // 获取供应商可以生产的所有备件
        List<String> spareAll = inquirySheetMapper.querySupplierForSpare(supplierList);
        // 存储没有被用到的供应商code
        List<String> freeSupplier = new ArrayList<>();
        // 遍历前端传来的供应商列表,对比是否需要,不需要存入空闲列表
        for (String code : supplierList) {
            // 存在就删除列表中的值，最后spareForSupplier为空说明全部有供应商生产
            if (spareForSupplier.contains(code)) {
                spareForSupplier.remove(code);
            }else {
                freeSupplier.add(code);
            }
        }
        List<String> freeSpare = new ArrayList<>();
        // 遍历前端传来的备件列表,对比是否能被生产,不能存入空闲列表
        for (String code : codeList) {
            // 存在就删除列表中的值，最后spareForSupplier为空说明全部有供应商生产
            if (!spareAll.contains(code)) {
                freeSpare.add(code);
            }
        }
        if (freeSpare.size() != 0){
            return ResultBuildVo.error(freeSpare.toString() + ParamUtil.NOT_SPARE_FOR_SUPPLIER + spareForSupplier.toString());
        }
        // 空闲的供应商有哪些备件可以生产
        if (freeSupplier.size() != 0){
            List<String> spareNeed = inquirySheetMapper.querySupplierForSpare(freeSupplier);
            return ResultBuildVo.error(freeSupplier.toString() + ParamUtil.NOT_SUPPLIER_FOR_SPARE + spareNeed.toString());
        }
        return null;
    }

    /**
     * 验证是否存在的情况
     */
    private static ResultVo getResultVo(CreateInquirySheetAddVo createInquirySheetAddVo) {
        // 2.验证类型是否存在
        boolean flag = false;
        for (TypeEnum typeEnum : TypeEnum.values()) {
            if (typeEnum.getName().equals(createInquirySheetAddVo.getType())) {
                flag = true;
            }
        }
        if (!flag) {
            return ResultBuildVo.error(ParamUtil.TYPE + ParamUtil.NOT_FOUNT);
        }
        // 3.验证币别是否存在
        flag = false;
        for (CurrencyEnum currencyEnum : CurrencyEnum.values()) {
            if (currencyEnum.getName().equals(createInquirySheetAddVo.getCurrencyCode())) {
                flag = true;
            }
        }
        if (!flag) {
            return ResultBuildVo.error(ParamUtil.CURRENCY + ParamUtil.NOT_FOUNT);
        }
        // 4.验证是否含税是否存在
        flag = false;
        for (TaxEnum taxEnum : TaxEnum.values()) {
            if (taxEnum.getName().equals(createInquirySheetAddVo.getIsTax())) {
                flag = true;
            }
        }
        if (!flag) {
            return ResultBuildVo.error(ParamUtil.IS_TAX + ParamUtil.NOT_FOUNT);
        }
        // 5.验证结束时间是否在开始时间之后
        if (!createInquirySheetAddVo.getStartTime().before(createInquirySheetAddVo.getEndTime())) {
            return ResultBuildVo.error(ParamUtil.TIME_ERROR);
        }
        // 6.验证询价数量，moq，交货周期是否大于零
//        for (InquiryDetails inquiryDetails : createInquirySheetAddVo.getInquiryDetailsList()) {
//            if (inquiryDetails.getInquiryQty() == null || inquiryDetails.getInquiryQty() == 0) {
//                return ResultBuildVo.error(ParamUtil.INQUIRY_COUNT + ParamUtil.NOT_ZERO);
//            }
//            if (inquiryDetails.getInquiryQty() == null || inquiryDetails.getMoq() == 0) {
//                return ResultBuildVo.error(ParamUtil.MOQ + ParamUtil.NOT_ZERO);
//            }
//            if (inquiryDetails.getInquiryQty() == null || inquiryDetails.getDeliveryCycle() == 0) {
//                return ResultBuildVo.error(ParamUtil.DELIVERY_CYCLE + ParamUtil.NOT_ZERO);
//            }
//        }
        return null;
    }

    /**
     * 生成订单号
     */
    public static String randomOrderCode(Date createTime) {
        SimpleDateFormat dmDate = new SimpleDateFormat("yyyyMMdd");
        String randata = getRandom(4);
        String dateran = dmDate.format(createTime);
        String Xsode = dateran + randata;
        if (Xsode.length() < 12) {
            Xsode = Xsode + 0;
        }
        return Xsode;
    }


    public static String getRandom(int len) {
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < len; i++) {
            rs.append(r.nextInt(10));
        }
        return rs.toString();
    }

}
