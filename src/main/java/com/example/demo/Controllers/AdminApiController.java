package com.example.demo.Controllers;

import com.example.demo.entity.RestBean;
import com.example.demo.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class AdminApiController {
    @Resource
    AdminService adminService;
    @GetMapping("/admins")
    public RestBean getAdmin(){
        return new RestBean(200,"success",adminService.getAllAdmins());
    }
    @PostMapping("/admins")
    public RestBean postAdmin(@RequestParam("account")String account, @RequestParam("psw")String psw, @RequestParam("role")String role,@RequestParam("status")String status){
        return new RestBean(200,"success",adminService.addAdmin(account,psw,role,status));
    }
    @DeleteMapping("/admins/delete")
    public RestBean deleteAdmin(@RequestParam("id")int id){
        return new RestBean(200,"success",adminService.deleteAdmin(id));
    }

    @GetMapping("/admins/search")
    public RestBean searchInfo(@RequestParam("id")int id){
        return new RestBean(200,"success",adminService.getAdmin(id));
    }
}
