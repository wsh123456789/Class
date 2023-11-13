package com.wsh.springboot.replacement_threshold.mapper;

import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdAddVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdSelectVo;
import com.wsh.springboot.replacement_threshold.model.ReplacementThresholdVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ReplacementThresholdMapper {

    List<ReplacementThresholdVo> queryData(ReplacementThresholdSelectVo replacementThresholdSelectVo);

    int queryCount(ReplacementThresholdSelectVo replacementThresholdSelectVo);

    void add(ReplacementThresholdVo replacementThresholdVo);

    @Select("select count(thresholdId) from threshold where legalpersonCode=#{legalPersonCode} and replacementCode=#{replacementCode}")
    int queryByCODES(ReplacementThresholdAddVo replacementThresholdAddVo);

    @Select("select * from threshold where thresholdId=#{thresholdId}")
    ReplacementThresholdVo queryById(Integer thresholdId);

    @Update("update threshold set threshold=#{threshold},remark=#{remark},version=version+1  where thresholdId=#{thresholdId} and version=#{version}")
    Integer update(ReplacementThresholdVo replacementThresholdVo1);

    @Select("select count(legalPersonCode) from legalperson where legalPersonCode=#{legalPersonCode}")
    int queryLegalCode(ReplacementThresholdAddVo replacementThresholdAddVo);

    @Select("select count(replacementCode) from replacement where replacementCode=#{replacementCode}")
    int queryReplacement(ReplacementThresholdAddVo replacementThresholdAddVo);
}
