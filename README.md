# Hospital_springBoot

> 在线医院问诊系统



## 1.项目开发简介

#### 1.1框架简介

##### 		采用springBoot框架

##### 		采用maven构建项目

##### 		采用IDEA开发工具		

#### 1.2数据库设计简介

#### 1.3实现功能简介

- admin超级管理员
  - [x] 增删改查 普通用户 医生
  - [x] 管理系统
- 普通用户
  - [x] 登录
  - [ ] 注册
  - [x] 查询和修改个人信息 病例
  - [ ] 查看就诊记录
  - [ ] 与医生会话
  - [ ] 按照疾病和相关描述检索医生信息
  - [ ] 按科室分类显示医生信息
  - [ ] 按照医院查询显示医生信息
- 医生
  - [ ] 查询和修改个人信息
  - [ ] 与病人建立会话

#### SQL语句

- 查找所有分类

```mysql
SELECT COUNT(DISTINCT(CategoryName))
FROM dis_category,disease
WHERE dis_category.CategoryName IN(
	SELECT dis_category.CategoryName
	FROM disease,dis_category
	WHERE disease.Dis_CategoryID = dis_category.Dis_CategoryID and DiseaseName != ""
)
```

- 获取所有分类

```sql



```

- 

```sql
UPDATE disease a,dis_category b
SET a.Dis_CategoryID = b.Dis_CategoryID 
WHERE b.CategoryName = a.Sub_Category
```



## 2.创建项目 

#### 2.1配置文件目录

- applicationContext.yaml

#### 2.2配置

- poe.xml
  - junit用于测试
  - junit-jupiter-api
  - Spring容器
  - mybatis
  - mybatis-spring
  - lombok
  - jstl
  - mysql-connector-java
  - commons-dbcp
  - javaeee-api

```xml
<dependencies>
        <!--org.springframework.boot官方-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
            <version>2.2.5.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.thymeleaf</groupId>
            <artifactId>thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-java8time</artifactId>
        </dependency>
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity5</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>

        <!--第三方-->
        <!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
        <!--<dependency>-->
            <!--<groupId>org.mybatis.spring.boot</groupId>-->
            <!--<artifactId>mybatis-spring-boot-starter</artifactId>-->
            <!--<version>2.1.2</version>-->
        <!--</dependency>-->

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <!--<scope>runtime</scope>-->
        </dependency>

        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.10</version>
        </dependency>
        <!-- 通用mapper -->
        <!-- https://mvnrepository.com/artifact/tk.mybatis/mapper-spring-boot-starter -->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper-spring-boot-starter</artifactId>
            <version>2.1.5</version>
        </dependency>

    </dependencies>

```

- applicationContext.yaml

```yaml
#端口
server.port: 8081

spring:
  #连接数据库
  datasource:
    username: root
    password: root
    url: jdbc:mysql://127.0.0.1:3306/doctor?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    driver-class-name: com.mysql.cj.jdbc.Driver
  #thymeleaf模板引擎
  thymeleaf:
    cache: false
```

