package com.hospital.main;

import com.hospital.main.bean.SysRole;
import com.hospital.main.bean.SysUser;
import com.hospital.main.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class MainApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }
    @Autowired
    UserService userService;
    @Test
    void test(){
        SysUser user = userService.getUser(1);
        List<SysRole> roles = user.getRoles();
        for (SysRole role:roles){
            System.out.println(role.getRoleDesc());
        }
        //user.setRoles();
        System.out.println(roles);
        //userInfo.setRoles();
    }
}
