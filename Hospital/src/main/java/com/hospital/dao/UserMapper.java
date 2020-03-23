package com.hospital.dao;

import com.github.abel533.mapper.Mapper;
import com.hospital.bean.SysRole;
import com.hospital.bean.SysUser;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface  UserMapper extends Mapper<SysUser> {
    //增加一个用户
    @Insert("INSERT doctor.sys_user(UserName,Password) VALUES (#{username},#{password})")
    public int addUser(SysUser sysUser);
    //删除一个用户
    @Delete("delete from doctor.sys_user where id = (#{id})")
    public int deleteUser(@Param("id") int id);
    //获取一个用户
    @Select("select * from doctor.sys_user where id = (#{id})")
    public SysUser getUser(@Param("id") long id);
    //获取一个用户通过用户名

    @Select("select * from doctor.sys_user where Username = (#{username})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many = @Many(select = "com.hospital.dao.RoleMapper.getRolesById"))
    })
    public SysUser getUserByName(@Param("username") String username);
    //获取一个用户通过用户名
    public SysUser getRoleName(String username);
    //更新一个用户
    @Update("update doctor.sys_user set Username = (#{username}),Password = (#{password}) where id = (#{id})")
    public int updateUser(SysUser sysUser);
    //获取全部的用户
    @Select("select * from doctor.sys_user")
    public  List<SysUser> getAllUser();
    //计数
    public int count();
}
