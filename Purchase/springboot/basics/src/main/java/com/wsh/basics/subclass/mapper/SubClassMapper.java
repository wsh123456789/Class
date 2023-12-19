package com.wsh.basics.subclass.mapper;

import com.wsh.basics.subclass.model.SubClassSelectVo;
import com.wsh.basics.subclass.model.SubClassVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SubClassMapper {

    //  查询数据
    List<SubClassVo> queryData(SubClassSelectVo subClassSelectVo);

    // 查询总数
    int queryCount(SubClassSelectVo subClassSelectVo);
    @Select("select count(id) from subclass where code = #{code} and id != #{id}")
    int queryByCode(@Param("code") String code, @Param("id")Integer id);

    @Select("select count(id) from subclass where name = #{name} and id != #{id}")
    int queryByName(@Param("name") String name, @Param("id")Integer id);

    void add(SubClassVo subClassVo);
    @Select("select * from subclass where id = #{id}")
    SubClassVo queryById(Integer id);

    @Update("update subclass set name=#{name},status=#{status},remark=#{remark},version=version+1  where id=#{id} and version=#{version}")
    Integer update(SubClassVo subClassVo);

    @Update("update subclass set status=#{status},version=version+1 where id=#{id} and version=#{version}")
    Integer updateStatus(SubClassVo subClassVo);

//    void update(SpareVo subClassVo);
//
//    @Update("update subclass set status=#{status} where id = #{id}")
//    void updateStatusById(SubClassStatusVo subClassStatusVo);
//
//    Integer getTotalSize(QuerySubClassVo querySubClassVo);

//    List<SpareVo> querySubClassPage(@Param("page") int page, @Param("page_count")Integer pageCount, @Param("querySubClassVo") QuerySubClassVo querySubClassVo);


}
