package com.hospital.config;

import com.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //把用户定义在内存中
        //auth.inMemoryAuthentication().withUser("admin").password("{noop}123123").roles("USER");
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
    //过滤资源
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                        "/assets/**",
                        "/login.jsp",
                        "/register.jsp");
    }

    //HttpSecurity验证用户的身份信息
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").hasAnyRole("USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .httpBasic();
    }
}
