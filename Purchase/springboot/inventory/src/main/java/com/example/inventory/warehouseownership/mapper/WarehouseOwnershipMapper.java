package com.example.inventory.warehouseownership.mapper;

import com.example.inventory.storagesection.model.StorageSectionVo;
import com.example.inventory.warehouse.model.WarehouseVo;
import com.example.inventory.warehouseownership.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WarehouseOwnershipMapper {


    List<WarehouseOwnershipVo> queryData(WarehouseOwnershipSelectVo warehouseOwnershipSelectVo);

    int queryCount(WarehouseOwnershipSelectVo warehouseOwnershipSelectVo);


    List<WarehouseOwnershipVo> queryWarehouse(QueryWarehouseSelectVo queryWarehouseSelectVo);
    @Select("SELECT s.name,s.code,s.remark,s.status from  storagesection s " +
            "LEFT JOIN storagebin sb ON sb.storageSectionCode=s.code " +
            "LEFT JOIN legalperson l ON l.legalPersonId=sb.legalPersonId where l.legalPersonId=#{legalPersonId} ")
    List<StorageSectionVo> queryStorageSectionByLegalPersonId(Integer legalPersonId);

    List<StorageSectionVo> queryStorageSection(WareHouseCodeAndStorageSectionName wareHouseCodeAndStorageSectionName);

    List<StorageBinVo> queryStorageBinByWareHouseAndStorageSectionCode(WareHouseAndStorageSectionCode wareHouseAndStorageSectionCode);
    @Select("SELECT DISTINCT w.code,w.name,w.remark,w.status,w.area,w.city,w.county,w.nation,w.province,w.detailAddress " +
            "from warehouse w LEFT JOIN storagesection s ON w.code=s.wareHouseCode LEFT JOIN storagebin sb " +
            "ON sb.storageSectionCode=s.code LEFT JOIN legalperson l ON l.legalPersonId=sb.legalPersonId where l.legalPersonId=#{legalPersonId}")
    List<WarehouseVo> queryWarehouseByLegalPersonId(Integer legalPersonId);
    @Select("SELECT sb.code,sb.name,sb.remark,sb.status from storagebin sb LEFT JOIN legalperson l ON l.legalPersonId=sb.legalPersonId\n" +
            "where l.legalPersonId=#{legalPersonId}")
    List<StorageBinVo> queryStorageBinByLegalPersonId(Integer legalPersonId);

    @Select("select count(legalPersonId) from legalperson where legalPersonId=#{legalPersonId};")
    int queryByLegalPersonId(Integer legalPersonId);

    void delete(WarehouseOwnershipAddVo warehouseOwnershipAddVo);

    void add(WarehouseOwnershipAddVo warehouseOwnershipAddVo);
}
