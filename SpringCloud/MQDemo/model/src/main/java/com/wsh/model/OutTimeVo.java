package com.wsh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutTimeVo {
    private String orderCode;
    private List<SpareVo> spareVos;
}
