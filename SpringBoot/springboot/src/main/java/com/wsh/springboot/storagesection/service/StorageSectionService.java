package com.wsh.springboot.storagesection.service;

import com.wsh.springboot.storagesection.model.StorageSectionAddVo;
import com.wsh.springboot.storagesection.model.StorageSectionSelectVo;
import com.wsh.springboot.storagesection.model.StorageSectionUpdateStatusVo;
import com.wsh.springboot.storagesection.model.StorageSectionUpdateVo;
import com.wsh.springboot.util.ResultVo;

public interface StorageSectionService {

    ResultVo add(StorageSectionAddVo storageSectionAddVo);

    ResultVo update(StorageSectionUpdateVo storageSectionUpdateVo);

    ResultVo updateStatus(StorageSectionUpdateStatusVo storageSectionUpdateStatusVo);

    ResultVo queryPage(StorageSectionSelectVo storageSectionSelectVo);
}
