package com.example.demo.service;

import com.example.demo.entity.Info;
import com.example.demo.mapper.InfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
@Service
public class InfoService {
    @Resource
    InfoMapper infoMapper;

    public Info[] getAllInfos(int offset,int limit)
    {
        return infoMapper.findAllInfos(offset,limit);
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
    public int getInfoSum()
    {
        return infoMapper.findInfoSum();
    }
    public Info[] getInfo(String name,String tel,String orderId)
    {
        return infoMapper.findInfoByNameAndTelAndAddress(name,tel,orderId);
    }
}
