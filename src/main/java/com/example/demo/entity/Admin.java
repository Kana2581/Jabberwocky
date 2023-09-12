package com.example.demo.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Admin {
    int uid;
    String account;
    String psw;

    Timestamp createAt;
    String role;
    String status;
}
