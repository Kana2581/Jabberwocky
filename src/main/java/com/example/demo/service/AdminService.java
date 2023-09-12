package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Info;
import com.example.demo.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {
    @Resource
    AdminMapper adminMapper;

    public Admin[] getAllAdmins()
    {
        return adminMapper.findAllAdmins();
    }
    public boolean addAdmin(String account, String psw,String role,String status)
    {
        return adminMapper.loadAdmin(account,psw,role,status);
    }
    public boolean deleteAdmin(int id)
    {
        return adminMapper.dropAdminsById(id);
    }

    public Admin getAdmin(int id)
    {
        return adminMapper.findAdminsById(id);
    }
}
