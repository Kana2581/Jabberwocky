package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AuthMapper {
    @Select("SELECT EXISTS (select * from admins where account =#{account} and psw=md5(#{psw})) AS product_exists;")
    public int findAccountByAccountAndPwd(@Param("account") String account,@Param("psw")String psw);
    @Select("select * from admins where account =#{account};")
    public Admin findAccountByAccount(@Param("account") String account);


}
