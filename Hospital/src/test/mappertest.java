import com.hospital.bean.SysUser;
import com.hospital.dao.UserMapper;
import com.hospital.service.UserService;
import com.hospital.serviceImpl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class mappertest {

    @Test
    public void test(){
       ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
       UserMapper userMapper = context.getBean("userMapper",UserMapper.class);
       for (SysUser sysUser:userMapper.getAllUser()){
           System.out.println(sysUser.getUsername());
       }
    }
    @Test
    public void test_1(){
        UserMapper userMapper = null;
        List<SysUser> list = userMapper.getAllUser();
        System.out.println(list);
    }
    @Test
    public void test_2(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123123"));

    }

    @Test
    public void test_3(){
        // userService =new UserServiceImpl();
        //List<SysUser> allUser = userService.getAllUser();
        // SysUser sysUser = userMapper.getUserByName("admin");
    }
}
