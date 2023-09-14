package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.mapper.AuthMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthService implements UserDetailsService {
    @Resource
    AuthMapper authmapper;
    public boolean verifyAccount(String account,String psw)  {
        return authmapper.findAccountByAccountAndPwd(account, psw)==1;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin account=authmapper.findAccountByAccount(username);
        if(account==null)
            throw new UsernameNotFoundException("不存在的用户");
        return User.withUsername(account.getAccount()).password(account.getPsw()).roles(account.getRole()).build();
    }
}
