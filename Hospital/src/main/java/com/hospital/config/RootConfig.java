package com.hospital.config;


import com.hospital.dao.RoleMapper;
import com.hospital.dao.UserMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//@Configuration
@ComponentScan(basePackages={"com"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION, value= EnableWebMvc.class)
        })
@MapperScan("com.hospital.dao")
@Configuration
@PropertySource("classpath:/com/hospital/config/jdbc.properties")
@EnableTransactionManagement
public class RootConfig {

        @Value("${jdbc.driverClassName}")
        private String driverClassName;
        @Value("${jdbc.url}")
        private String url;
        @Value("${jdbc.username}")
        private String username;
        @Value("${jdbc.password}")
        private String password;

        /**
         * 数据源
         * @return
         */
        @Bean
        public DriverManagerDataSource dataSource() {
                DriverManagerDataSource ds = new DriverManagerDataSource();
                ds.setDriverClassName(driverClassName);
                ds.setUrl(url);
                ds.setUsername(username);
                ds.setPassword(password);
                return ds;
        }

        @Bean
        DataSourceTransactionManager DataSourceTransactionManager(DriverManagerDataSource dataSource) {
                DataSourceTransactionManager dstm = new DataSourceTransactionManager();
                dstm.setDataSource(dataSource);
                return dstm;
        }

        @Bean
        JdbcTemplate jdbcTemplate (DriverManagerDataSource dataSource) {
                return new JdbcTemplate(dataSource);
        }

        /**
         * SqlSessionFactoryBean配置
         * @param dataSource
         * @return
         */
        @Bean
        SqlSessionFactoryBean sqlSessionFactoryBean(DriverManagerDataSource dataSource) {

                SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
                sqlSessionFactoryBean.setDataSource(dataSource);
                /* 设置mybatis configuration 扫描路径 */
                /**   mybatis 配置路径     */
                String MYBATIS_CONFIG = "mybatis-config.xml";
                sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
                /** 设置typeAlias 包扫描路径 */
                String typeAliasPackage = "com.hospital.dao";
                sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
                //org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration() ;
                //sqlSessionFactoryBean.setConfiguration(configuration);

                return sqlSessionFactoryBean;
        }

//        @Bean
//        MapperFactoryBean<UserMapper> mapperFactoryBean(SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
//                MapperFactoryBean<UserMapper> mapperFactoryBean = new MapperFactoryBean<UserMapper>();
//
//                mapperFactoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
//                mapperFactoryBean.setMapperInterface(UserMapper.class);
//
//                return mapperFactoryBean;
//        }

}
