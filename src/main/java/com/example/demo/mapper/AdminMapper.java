package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Info;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminMapper {
    @Select("select * from admins")
    public Admin[] findAllAdmins();

    @Select("select * from admins where id=#{id}")
    public Admin findAdminsById(@Param("id") int id);
    @Insert("insert into admins(account,psw,role,status) value(#{account},#{psw},#{role},#{status})")
    public boolean loadAdmin(@Param("account") String account,@Param("psw")String psw,@Param("role")String role,@Param("status")String status);
    @Delete("delete from admins where id=#{id}")
    public Boolean dropAdminsById(@Param("id")int id);
}
