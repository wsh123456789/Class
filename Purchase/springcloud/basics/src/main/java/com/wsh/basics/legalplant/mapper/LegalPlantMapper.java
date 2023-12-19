package com.wsh.basics.legalplant.mapper;

import com.wsh.basics.legalplant.model.LegalPlantSelectVo;
import com.wsh.basics.legalplant.model.LegalPlantVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LegalPlantMapper {
    List<LegalPlantVo> queryData(LegalPlantSelectVo legalPlantSelectVo);

    int queryCount(LegalPlantSelectVo legalPlantSelectVo);

    @Select("select count(id) from suppliers where legalPlantCode = #{legalPlantCode}")
    int queryByCode(String legalPlantCode);

    void add(LegalPlantVo legalPlantVo);

    @Select("select * from suppliers where id = #{id}")
    LegalPlantVo queryById(Integer id);

    @Update("update suppliers set legalPlantDec=#{legalPlantDec},enabled=#{enabled},version=version+1 where id=#{id} and version=#{version}")
    int update(LegalPlantVo legalPlantVo);

    @Update("update suppliers set enabled=#{enabled},version=version+1 where id=#{id} and version=#{version}")
    int updateStatus(LegalPlantVo legalPlantVo);
}
