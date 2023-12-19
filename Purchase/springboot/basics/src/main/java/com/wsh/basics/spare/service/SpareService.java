package com.wsh.basics.spare.service;


import com.wsh.basics.spare.model.SpareAddVo;
import com.wsh.basics.spare.model.SpareSelectVo;
import com.wsh.basics.spare.model.SpareUpdateStatusVo;
import com.wsh.basics.spare.model.SpareUpdateVo;
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
