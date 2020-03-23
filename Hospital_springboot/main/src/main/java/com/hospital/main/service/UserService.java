package com.hospital.main.service;

import com.hospital.main.bean.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    //增加一个用户
    public int addUser(SysUser sysUser);
    //删除一个用户
    public int deleteUser(int id);
    //获取一个用户
    public SysUser getUser(long id);
    //更新一个用户
    public int updateUser(SysUser sysUser);
    //获取全部的用户
    public List<SysUser> getAllUser();
    //计数
    public int count();
    public SysUser getUserbyName(String username);
}
