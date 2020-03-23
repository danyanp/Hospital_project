import com.hospital.bean.SysUser;
import com.hospital.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Springtest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("UserService");
        System.out.println(userService.getAllUser());
    }
    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext("applicationContext.xml");
        System.out.println(context.getBean("userServiceImpl"));
    }

}
