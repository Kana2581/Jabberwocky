package com.example.demo.mapper;

import com.example.demo.entity.Info;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface InfoMapper {

    @Select("select * from info limit #{limit} offset #{offset}")
    public Info[] findAllInfos(@Param("offset")int offset,@Param("limit")int limit);

    @Select("select * from info where id=#{id}")
    public Info findInfoById(@Param("id") int id);

    @Select("select COUNT(*) from info")
    public int findInfoSum();

    @Insert("insert into info(name,tel,address,order_id) value(#{name},#{tel},#{address},#{orderId})")
    public boolean loadInfo(@Param("name") String name,@Param("tel")String tel,@Param("address")String address,@Param("orderId")String orderId);
    @Delete("delete from info where id=#{id}")
    public Boolean dropInfoById(@Param("id")int id);

    @Select("select * from info where name like '%${name}%' and tel like '%${tel}%' and order_id like '%${orderId}%'")
    public Info[] findInfoByNameAndTelAndAddress(@Param("name")String name, @Param("tel")String tel, @Param("orderId")String orderId);
}
