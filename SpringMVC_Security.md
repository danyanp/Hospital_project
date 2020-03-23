# SpringMVC_Security学习

## 3.安全登录验证

> #### [security是什么？](https://www.springcloud.cc/spring-security-zhcn.html#what-is-acegi-security)

> #### [官方文档](https://www.springcloud.cc/spring-security-zhcn.html#modules]



**认证：登录后，让系统得到当前用户的角色身份**

**授权：根据角色身份，授予权限资源**



**用户：包含用户名，密码等角色信息，可以实现认证操作**

**角色：包含角色名称，角色描述，当前角色拥有的权限信息，可以实现权限操作**

**权限：包含当前权限名称，url地址等信息，用户与权限没有直接关系**



#### 3.1 引入框架security

```xml
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
            <version>5.2.2.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
            <version>5.2.2.RELEASE</version>
        </dependency>
```

#### 3.2 配置web.xml

```xml
<!--监听器-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml,classpath:security.xml</param-value>
    </context-param>
 <!--filter权限框架过滤器执行链-->
    <filter>
        <filter-name>springSecurityFilterChain</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>springSecurityFilterChain</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

```



#### 3.3 创建spring-security.xml配置文件

- 最基本配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/security
        http://www.springframework.org/schema/security/spring-security.xsd">

    <security:http auto-config="true"  use-expressions="true">
        <security:intercept-url pattern="/**" access="hasAnyRole('ROLE_USER')"/>
    </security:http>
    <security:authentication-manager>
        <security:authentication-provider>
            <security:user-service>
                <security:user name="admin" password="{noop}123456" authorities="ROLE_USER"/>
            </security:user-service>
        </security:authentication-provider>
    </security:authentication-manager>
</beans>
```

- 中等配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:security="http://www.springframework.org/schema/security"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/security
        http://www.springframework.org/schema/security/spring-security.xsd">
    <security:http pattern="/assets/**" security="none"/>
    <security:http auto-config="true"  use-expressions="true">
        <security:intercept-url pattern="/login.jsp" access="permitAll()"/>
        <security:intercept-url pattern="/**" access="permitAll()"/>
        <security:form-login login-page="/login.jsp"
                             login-processing-url="/Login"
                             default-target-url="/index.jsp"
                             authentication-failure-url="/index.jsp"/>
        <security:logout logout-url="/logout" logout-success-url="/login.jsp"/>
        <security:csrf disabled="true"/>
    </security:http>

    <security:authentication-manager>
        <security:authentication-provider>
            <security:user-service>
                <security:user name="admin" password="{noop}123456" authorities="ROLE_USER"/>
            </security:user-service>
        </security:authentication-provider>
    </security:authentication-manager>
</beans>
```



- 完整配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:security="http://www.springframework.org/schema/security"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/security
    http://www.springframework.org/schema/security/spring-security.xsd">
    <!--放行页面不被权限框架拦截验证-->
    <security:http pattern="/login.jsp" security="none"></security:http>
    <security:http pattern="/failer.jsp" security="none"></security:http>
    <security:http pattern="/css/**" security="none"></security:http>
    <security:http pattern="/img/**" security="none"></security:http>
    <security:http pattern="/plugins/**" security="none"></security:http>
    <security:http pattern="/pages/**" security="none"></security:http>

    <!--配置拦截的规则
     auto-config="true" 开启框架的默认配置支持
     use-expressions="false" 关闭表达式的支持
     intercept-url pattern="/**" 拦截所有的请求
     access="ROLE_USER"  拥有ROLE_USER角色的用户可以访问资源
     -->
    <security:http auto-config="true" use-expressions="true">
   	 <!--使用springmvc提供的记住登录功能，
	    user-service-ref映射到权限实现类userService
	    key	浏览器访问存的cookie名称，随便起个名字，不用管
		login.jsp里面记住我复选框checkbox的name属性必须是“remember-me”，其他无效
		-->
        <security:remember-me user-service-ref="userService" key="rememberUser"></security:remember-me>
        <!--给角色赋予权限-->
        <security:intercept-url pattern="/**" access="hasAnyRole('ROLE_USER','ROLE_ORDER','ROLE_ADMIN','ROLE_PRODUCT')"></security:intercept-url>
        <!--配置权限框架自定义面登录节点
         login-page 自定义登录页
           login-processing-url 登录页面表单发起登录请求的url路径
           default-target-url 登录成功跳转的页面
           authentication-failure-url 验证失败跳转的页面
           -->
        <security:form-login login-page="/login.jsp"
                             login-processing-url="/login"
                             default-target-url="/index.jsp"
                             authentication-failure-url="/failer.jsp"></security:form-login>

        <!--注销按钮的处理节点-->
        <security:logout logout-url="/logout" logout-success-url="/login.jsp" invalidate-session="true"></security:logout>
        <!--访问资源无权限拒绝的处理-->
        <security:access-denied-handler error-page="/403.jsp"></security:access-denied-handler>
        <!--csrf攻击拦截的关闭-->
        <security:csrf disabled="true"></security:csrf>
    </security:http>

    <!--权限验证使用自定义的实现类，这里配置的是userService作为权限实现类-->
    <security:authentication-manager>
        <security:authentication-provider user-service-ref="userService">
            <!-- 提供加密方式 -->
            <security:password-encoder ref="pwdEncoder"></security:password-encoder>
        </security:authentication-provider>
    </security:authentication-manager>
    <security:global-method-security secured-annotations="enabled"></security:global-method-security>
    <!--通过xml文件初始化加密的工具类交给容器管理-->
    <bean id="pwdEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"></bean>
</beans>
```



#### 3.4 实现验证用户

#### 3.5 权限控制



