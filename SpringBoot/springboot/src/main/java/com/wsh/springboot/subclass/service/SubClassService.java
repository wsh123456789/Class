package com.wsh.springboot.subclass.service;

import com.wsh.springboot.subclass.model.*;
import com.wsh.springboot.util.ResultVo;

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
