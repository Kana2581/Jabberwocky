package com.example.demo.mapper;

import com.example.demo.entity.Info;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InfoMapper {

    @Select("select * from info")
    public Info[] findAllInfos();

    @Select("select * from info where id=#{id}")
    public Info findInfoById(@Param("id") int id);
    @Insert("insert into info(name,tel,address,order_id) value(#{name},#{tel},#{address},#{orderId})")
    public boolean loadInfo(@Param("name") String name,@Param("tel")String tel,@Param("address")String address,@Param("orderId")String orderId);
    @Delete("delete from info where id=#{id}")
    public Boolean dropInfoById(@Param("id")int id);
}
