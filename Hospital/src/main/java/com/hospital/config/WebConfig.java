package com.hospital.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//启动MVC功能
@Configuration
@EnableWebMvc
@ComponentScan("com.hospital.controller")
public class WebConfig implements WebMvcConfigurer {
    //视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp",".jsp");
    }
    //重写了它的 configureDefaultServletHandling()方法，
    //通过调用所给的DefaultServletHandlerConfigurer对象的enable()方法，
    //告诉DispatcherServlet 转发对静态资源的 Request到Servlet容器的默认Servlet，
    //而不是自己处理。
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
