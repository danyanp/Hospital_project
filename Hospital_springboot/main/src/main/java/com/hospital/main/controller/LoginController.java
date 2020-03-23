package com.hospital.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String doLogin(){
        return "login";
    }
    @RequestMapping("/register")
    public String Register(){
        return "register";
    }

}
