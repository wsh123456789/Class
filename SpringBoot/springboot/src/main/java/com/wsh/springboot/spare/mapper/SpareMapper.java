package com.wsh.springboot.spare.mapper;

import com.wsh.springboot.spare.model.SpareSelectVo;
import com.wsh.springboot.spare.model.SpareVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SpareMapper {

    //  查询数据
    List<SpareVo> queryData(SpareSelectVo spareSelectVo);

    // 查询总数
    int queryCount(SpareSelectVo spareSelectVo);
    @Select("select count(id) from spare where code = #{code} and id != #{id}")
    int queryByCode(@Param("code") String code, @Param("id")Integer id);

    @Select("select count(id) from spare where name = #{name} and id != #{id}")
    int queryByName(@Param("name") String code, @Param("id")Integer id);

    void add(SpareVo spareVo);
    @Select("select * from spare where id = #{id}")
    SpareVo queryById(Integer id);

    @Update("update spare set name=#{name},status=#{status},remark=#{remark},version=version+1 where id=#{id} and version=#{version}")
    int update(SpareVo spareVo);

    @Update("update spare set status=#{status},version=version+1 where id=#{id} and version=#{version}")
    int updateStatus(SpareVo spareVo);
//    Integer queryTotalSize(SpareVo pageVo);
//
//    List<SpareVo> querySparePage(@Param("page") int page, @Param("page_count")Integer pageCount,@Param("spareVo") SpareVo spareVo);
//
//    @Select("select count(id) from spare where code = #{code} and id != #{id}")
//    int queryByCode(@Param("code") String code, @Param("id") Integer id);
//
//    @Select("select count(id) from spare where name = #{name} and id != #{id}")
//    int queryByName(@Param("name") String code, @Param("id") Integer id);
//
//    void add(SpareVo spareVo);
//
//    @Select("select id,code,name,remark,status from spare where id = #{id}")
//    SpareUpdateVo queryById(Integer id);
//
//    void update(SpareVo spareVo);
//
//    @Select("select id,code,name,remark,status from spare where id = #{id}")
//    void updateStatusById(SpareStatusVo spareStatusVo);
}
