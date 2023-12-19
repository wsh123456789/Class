package com.wsh.supplier.service.impl;

import com.wsh.model.AddVo;
import com.wsh.model.OrderVo;
import com.wsh.model.OutTimeVo;
import com.wsh.model.SpareVo;
import com.wsh.supplier.mapper.SupplierMapper;
import com.wsh.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Map<String,Integer> hasInventory(AddVo addVo) {
        // 获取备件对应的数据
        List<OrderVo> spares = supplierMapper.queryInventory(addVo);
        // 创建map返回库存不足的备件信息
        Map<String,Integer> errorSpare = new HashMap<>();
        // 遍历筛选哪一个库存不足存入map
        for (OrderVo spare:spares) {
            for (SpareVo spareVo:addVo.getSpareList()){
                if (spareVo.getSpareCode().equals(spare.getSpareCode())){
                    int inventory = spare.getCount()-spare.getOccupyCount()-spareVo.getCount();
                    // 给占用数据重新赋值
                    spare.setOccupyCount(spare.getOccupyCount()+spareVo.getCount());
                    if (inventory < 0){
                        errorSpare.put(spare.getSpareCode(),spare.getCount()-spare.getOccupyCount());
                    }
                }
            }

        }
        // 批量修改备件的数据
        if (errorSpare.isEmpty()){
            supplierMapper.updateInventory(spares);
        }
        System.out.println(errorSpare);
        return errorSpare;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AddVo addVo) {
        // 基础信息存入数据库
        supplierMapper.add(addVo);
        // 数量存入采购备件表
        supplierMapper.addCount(addVo);
        // 库存减少
        supplierMapper.subInventory(addVo);
    }

    // 释放
    @Scheduled(cron = "0/5 * * * * ?")
    public void free(){
        // 查询所有超时订单
        Date now = new Date();
        long createTime = now.getTime() - 24*60*60*1000;
        List<OutTimeVo> outTimeVos = supplierMapper.queryOutTime(createTime);
        System.out.println(outTimeVos);
        if (!outTimeVos.isEmpty()){
            // 释放所有订单并把状态改为0
            supplierMapper.free(outTimeVos);
        }
    }


//    public static void main(String[] args) {
//        Date now = new Date();
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.DATE,-1);
//        String str = String.valueOf(c.getTime());
//        System.out.println(str);
//    }
}
