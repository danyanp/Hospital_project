package com.hospital.main.controller;

import com.hospital.main.bean.Case;
import com.hospital.main.bean.SysRole;
import com.hospital.main.bean.SysUser;
import com.hospital.main.service.CaseService;
import com.hospital.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    CaseService caseService;

    @Autowired
    public UserController(@Qualifier("UserServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/info/{a}")
    public String userDetail(@PathVariable long a, Model model){
        SysUser userInfo = userService.getUser(a);
        List<Case> caseByUserId = caseService.getCaseByUserId(a);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("userCase",caseByUserId);
        return "info";
    }
    //获取一个用户
    @GetMapping("user/{a}")
    @ResponseBody
    public SysUser getUser(@PathVariable("a") long a){
        return  userService.getUser(a);
    }
    //新增一个用户
    @PostMapping("/user")
    @ResponseBody
    public int addUser(SysUser sysUser){
        System.out.println("addUser");
        System.out.println(sysUser);
        return userService.addUser(sysUser);
    }
    //删除一个用户
    @DeleteMapping("user/{b}")
    @ResponseBody
    public int deleteUser(@PathVariable("b") int b){
        System.out.println(b);
        return userService.deleteUser(b);
    }
    //修改一个用户
    @PutMapping("user/{c}")
    @ResponseBody
    public int updateUser(@PathVariable("c") long c, SysUser sysUser){
        System.out.println("updateUser");
        System.out.println(c);
        sysUser.setId(c);
        System.out.println(sysUser);
        return userService.updateUser(sysUser);
    }
    //获取所有用户

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<SysUser> Login(){
        return userService.getAllUser();
    }

    //通过用户名获取用户
    @RequestMapping("/getUserbyName/{username}")
    @ResponseBody
    public SysUser getUserbyName(@PathVariable String username){
        return userService.getUserbyName(username);
    }
//    @RequestMapping("/Login/")
//    @ResponseBody
//    public String Login(Model model){
//        List<SysUser> list = userService.getAllUser();
//        model.addAttribute("list",list);
//        return "login";
//    }

}
