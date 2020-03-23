package com.hospital.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//SpringMVC入口配置文件
public class MvcWebApplicationInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class,SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }


    // ... other overrides ...
}
