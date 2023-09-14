package com.example.demo.Controllers;

import com.example.demo.entity.RestBean;
import com.example.demo.service.UserAuthService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@RestController
public class AuthApiController {
    @Resource UserAuthService userAuthService;
//    @RequestMapping("/login")
//    public RestBean login(@RequestParam("account") String account,@RequestParam("password") String password){
//        return new RestBean(200,"success",userAuthService.verifyAccount(account,password));
//    }







}
