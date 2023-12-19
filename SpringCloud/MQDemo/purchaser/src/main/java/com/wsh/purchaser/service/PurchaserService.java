package com.wsh.purchaser.service;

import com.wsh.model.AddVo;
import com.wsh.purchaser.utils.ResultVo;

public interface PurchaserService {
    ResultVo add(AddVo addVo);

    ResultVo check(AddVo addVo);
}
