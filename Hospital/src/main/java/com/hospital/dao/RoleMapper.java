package com.hospital.dao;

import com.github.abel533.mapper.Mapper;
import com.hospital.bean.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends Mapper<SysRole> {
    @Select("SELECT r.ID id,r.ROLE_NAME roleName, r.ROLE_DESC roleDesc FROM sys_user_role ur,sys_role r WHERE r.ID = ur.RID AND ur.UID = #{id}")
    public List<SysRole> getRolesById(@Param("id") long id);
}
