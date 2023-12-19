package com.wsh.basics.spare.service;


import com.wsh.basics.spare.model.*;
import com.wsh.basics.util.ResultVo;

public interface SpareService {

    ResultVo queryPage(SpareSelectVo spareSelectVo);

    ResultVo add(SpareAddVo spareAddVo);

    ResultVo update(SpareUpdateVo spareUpdateVo);

    ResultVo updateStatus(SpareUpdateStatusVo spareUpdateStatusVo);

    /*
    * 分页查询
    * */
//    PageVo queryPageVo(SpareVo pageVo, Integer currentPage);
//
//    ResultVo add(SpareAddVo spareAddVo);
//
//    ResultVo showUpdate(Integer id);
//
//    ResultVo update(SpareUpdateVo spareUpdateVo);
//
//    ResultVo updateStatusById(SpareStatusVo spareStatusVo);
}
