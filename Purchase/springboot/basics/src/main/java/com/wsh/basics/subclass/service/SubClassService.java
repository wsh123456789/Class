package com.wsh.basics.subclass.service;


import com.wsh.basics.subclass.model.SubClassAddVo;
import com.wsh.basics.subclass.model.SubClassSelectVo;
import com.wsh.basics.subclass.model.SubClassUpdateStatusVo;
import com.wsh.basics.subclass.model.SubClassUpdateVo;
import com.wsh.basics.util.ResultVo;

public interface SubClassService {
    ResultVo queryPage(SubClassSelectVo subClassSelectVo);

    ResultVo add(SubClassAddVo subClassAddVo);

    ResultVo update(SubClassUpdateVo subClassUpdateVo);

    ResultVo updateStatus(SubClassUpdateStatusVo subClassUpdateStatusVo);

//    ResultVo add(SpareAddVo subClassAddVo);
//
//    ResultVo showUpdate(Integer id);
//
//    ResultVo update(SpareUpdateVo subClassUpdateVo);
//
//    ResultVo updateStatusById(SubClassStatusVo subClassStatusVo);


}
