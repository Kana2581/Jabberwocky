package com.example.demo.Controllers;

import com.example.demo.entity.RestBean;
import com.example.demo.service.InfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class InfoApiController {
    @Resource
    InfoService infoService;
    @GetMapping("/info")
    public RestBean getInfo(){
        return new RestBean(200,"success",infoService.getAllInfos());
    }
    @PostMapping("/info")
    public RestBean postInfo(@RequestParam("name")String name,@RequestParam("tel")String tel,@RequestParam("address")String address){
        return new RestBean(200,"success",infoService.addInfo(name,tel,address,"233"));
    }
    @DeleteMapping("/info/delete")
    public RestBean deleteInfo(@RequestParam("id")int id){
        return new RestBean(200,"success",infoService.deleteInfo(id));
    }

    @GetMapping("/info/search")
    public RestBean searchInfo(@RequestParam("id")int id){
        return new RestBean(200,"success",infoService.getInfo(id));
    }
}
