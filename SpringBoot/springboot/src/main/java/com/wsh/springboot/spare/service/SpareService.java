package com.wsh.springboot.spare.service;


import com.wsh.springboot.spare.model.*;
import com.wsh.springboot.spare.model.SpareAddVo;
import com.wsh.springboot.spare.model.SpareSelectVo;
import com.wsh.springboot.spare.model.SpareUpdateStatusVo;
import com.wsh.springboot.spare.model.SpareUpdateVo;
import com.wsh.springboot.util.ResultVo;

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
