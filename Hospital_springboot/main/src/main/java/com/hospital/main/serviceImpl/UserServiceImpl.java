package com.hospital.main.serviceImpl;

import com.hospital.main.bean.SysUser;
import com.hospital.main.dao.UserMapper;
import com.hospital.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SuppressWarnings("ALL")
@Service("UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int addUser(SysUser sysUser) {
//        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        return userMapper.addUser(sysUser);
    }

    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    public SysUser getUser(long id) {
        return userMapper.getUser(id);
    }

    public int updateUser(SysUser sysUser) {
        return userMapper.updateUser(sysUser);
    }

    public List<SysUser> getAllUser() {
        return userMapper.getAllUser();
    }

    public int count() {
        return userMapper.count();
    }

    public SysUser getUserbyName(String username){
        return userMapper.getUserByName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userMapper.getUserByName(s);
    }
}
