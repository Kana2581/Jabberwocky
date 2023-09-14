package com.example.demo.Controllers;

import com.example.demo.entity.Info;
import com.example.demo.entity.RestBean;
import com.example.demo.service.InfoService;
import com.example.demo.utils.SFUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@RestController
public class InfoApiController {
    @Resource
    InfoService infoService;
    @GetMapping("/info")
    public RestBean getInfo(@RequestParam("page")int page,@RequestParam("limit")int limit){
        page--;
        int offset=page*limit;
        return new RestBean(200,""+infoService.getInfoSum(),infoService.getAllInfos(offset,limit));
    }
    @PostMapping("/info")

    public RestBean postInfo(@RequestBody Info info){
        String SFCode=null;
        try {
            SFCode=SFUtil.getSFCode(info.getName(),info.getTel(),info.getAddress());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }finally {
            if(SFCode==null)
            return new RestBean(400,"error");
            else
            return new RestBean(200,"success",infoService.addInfo(info.getName(),info.getTel(),info.getAddress(),SFCode));
        }
    }
    @DeleteMapping("/info/delete")
    public RestBean deleteInfo(@RequestParam("id")int id){
        return new RestBean(200,"success",infoService.deleteInfo(id));
    }

//    @GetMapping("/info/detail")
//    public RestBean searchInfo(@RequestParam("id")int id){
//        return new RestBean(200,"success",infoService.getInfo(id));
//    }
    @GetMapping("/info/search")
    public RestBean searchInfo(@RequestParam("name")String name,@RequestParam("tel")String tel,@RequestParam("orderId")String orderId){
        return new RestBean(200,"success",infoService.getInfo(name,tel,orderId));
    }
}
