package com.example.demo.service;

import com.example.demo.mapper.AuthMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthService  {
    @Resource
    AuthMapper authmapper;
    public boolean verifyAccount(String account,String psw)  {
        return authmapper.findAccountByAccountAndPwd(account, psw)==1;
    }





}
