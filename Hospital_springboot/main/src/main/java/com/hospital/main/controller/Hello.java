package com.hospital.main.controller;

import com.hospital.main.bean.SysUser;
import com.hospital.main.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
public class Hello {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public List<SysUser> hello(){
        List<SysUser> userList = userMapper.getAllUser();
        return userList;
    }
}
