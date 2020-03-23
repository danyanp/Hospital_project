package com.hospital.main.dao;

import tk.mybatis.mapper.common.Mapper;

import com.hospital.main.bean.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends Mapper<SysRole> {
    @Select("SELECT r.ID id,r.ROLE_NAME roleName, r.ROLE_DESC roleDesc FROM sys_user_role ur,sys_role r WHERE r.ID = ur.RID AND ur.UID = #{id}")
    public List<SysRole> getRolesById(@Param("id") long id);
}
