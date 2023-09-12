package com.example.demo.service;

import com.example.demo.entity.Info;
import com.example.demo.mapper.InfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class InfoService {
    @Resource
    InfoMapper infoMapper;

    public Info[] getAllInfos()
    {
        return infoMapper.findAllInfos();
    }
    public boolean addInfo(String name, String tel,String address,String orderId)
    {
        return infoMapper.loadInfo(name,tel,address,orderId);
    }
    public boolean deleteInfo(int id)
    {
        return infoMapper.dropInfoById(id);
    }

    public Info getInfo(int id)
    {
        return infoMapper.findInfoById(id);
    }
}
