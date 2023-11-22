package com.wsh.springboot.util;

public class ParamUtil {
    public static final String RMB = "人民币";
    public static final String DOLLAR = "美元";
    public static final String POUND = "英镑";
    public static final String IS_TAX = "是否含税";
    public static final String TAX = "含税";
    public static final String NULL_TAX = "不含税";
    public static final Integer FOUR = 4;
    public static final Integer THREE = 3;
    public static final Integer TWO = 2;
    public final static Integer ONE = 1;
    public final static Integer ZERO = 0;
    public final static String LEGAL_PERSON = "法人";
    public final static String LEGAL_PLANT = "工厂";
    public final static String SUBCLASS = "备件小类";
    public final static String SPARE = "计划大类";
    public final static String REPLACEMENT = "备件";
    public final static String THRESHOLD_NOTNULL = "阈值不能为空";
    public final static String THRESHOLD_MAX = "阈值最多为9999";
    public final static String REPLACEMENT_REPEAT = "备件已存在";

    public final static String ID_NOTNULL = "id不能为空";

    public final static String CODE_NOTNULL = "编码不能为空";

    public final static String NAME_NOTNULL = "名称不能为空";

    public final static String STATUS_NOTNULL = "状态不能为空";

    public final static String VERSION_NOTNULL = "版本号不能为空";
    public final static String REMARK_NOTNULL = "描述不能为空";

    public final static String UPDATE_MESSAGE_NOTFOUND = "要修改的对象信息不存在";
    public final static String UPDATE_DISABLED = "必须是禁用状态才能修改";
    public final static String NAME_REPEAT = "名称已存在";
    public final static String CODE_REPEAT = "编码重复";
    public final static String OPEN = "启用";
    public final static String CLOSE = "禁用";
    public final static String MESSAGE_IS_UPDATED = "数据已被修改，请刷新界面后重试";
    public final static String TRUE = "是";
    public final static String FALSE = "否";

    public final static String CHANGE_MAN = "张三";
    public final static int MAX_THRESHOLD = 9999;
    public final static String WAREHOUSE = "库房";
    public final static String WAREHOUSE_AREA = "库区";
    public final static String WAREHOUSE_POSITION = "库位";
    public final static String WAREHOUSE_TAG = "库房标识";
    public static final String INQUIRY = "询价";
    public static final String PROCUREMENT = "采购询价";
    public static final String DISPOSE = "处理询价";
    public static final String SCRAP = "报废询价";
    public static final String CREATE_TIME_NOTNULL = "创建时间不能为空";
    public static final String START_TIME_NOTNULL = "开始时间不能为空";
    public static final String END_TIME_NOTNULL = "结束时间不能为空";
    public static final String TYPE_NOTNULL = "类型不能为空";
    public static final String CURRENCY_NOTNULL = "币别不能为空";
    public static final String IS_TAX_NOTNULL = "是否含税";
    public static final String INQUIRY_DETAILS = "待询价明细列表不能为空";
    public static final String SUPPLIER_DETAILS = "待供应商报价列表不能为空";
    public final static String NOT_QUOTE = "未报价";
    public final static String SAVED = "已保存";
    public final static String SUBMITTED = "已提交";
    public final static String AUDITED = "已审核";
    public final static String VOIDED = "已作废";
    public final static String TYPE = "询价类型";
    public final static String NOT_FOUNT = "不存在";
    public static final String ORDER_FROM = "订单";
    public static final String CURRENCY = "币别";
    public static final String TIME_ERROR = "询价结束时间必须在询价开始时间之前";
    public static final String INQUIRY_COUNT = "询价数量";
    public static final String MOQ = "MOQ";
    public static final String DELIVERY_CYCLE = "交货周期";
    public static final String NOT_ZERO = "必须大于零";
    public static final Object NOT_SPARE_FOR_SUPPLIER = "备件没有供应商，对应的供应商为：";
    public static final String NOT_SUPPLIER_FOR_SPARE = "供应商没有生产备件，可生产的备件为：";
    public static final String ORDER_CODE_NOTNULL = "订单号不能为空";
    public static final String AUDITOR_TIME_NOTNULL = "审核时间不能为空";
    public static final String AUDITOR_STATUS_NOTNULL = "审核状态不能为空";
    public static final String APPROVER_TIME_NOTNULL = "审批时间不能为空";
    public static final String APPROVER_STATUS_NOTNULL = "审批状态不能为空";
    public static final String AUDITOR_STATUS_REPEAT = "此订单已审核，不能重复审核";
    public static final String APPROVER_STATUS_REPEAT = "此订单已审批，不能重复审批";
    public static final String INQUIRY_NOT_SUBMIT = "订单未提交不能审核";
}
