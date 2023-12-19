package com.example.inventory.storagesection.service;

import com.example.inventory.storagesection.model.StorageSectionAddVo;
import com.example.inventory.storagesection.model.StorageSectionSelectVo;
import com.example.inventory.storagesection.model.StorageSectionUpdateStatusVo;
import com.example.inventory.storagesection.model.StorageSectionUpdateVo;
import com.example.inventory.util.ResultVo;

public interface StorageSectionService {

    ResultVo add(StorageSectionAddVo storageSectionAddVo);

    ResultVo update(StorageSectionUpdateVo storageSectionUpdateVo);

    ResultVo updateStatus(StorageSectionUpdateStatusVo storageSectionUpdateStatusVo);

    ResultVo queryPage(StorageSectionSelectVo storageSectionSelectVo);
}
