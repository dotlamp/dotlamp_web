package com.dotlamp_web.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.dotlamp_web.service"})
@MapperScan(basePackages = {"com.dotlamp_web.mapper"})
public class RootConfig {


    /* Connection pool */
    @Bean
    public DataSource dataSource(){
        //String url = "jdbc:mysql://";
        String url = "jdbc:log4jdbc:mysql://"; //log4jdbc
        String server = "localhost:3306";
        String database = "edu_haenem";
        String user_name = "root";
        String password = "dotlamp";


        HikariConfig hikariConfig = new HikariConfig();
        //hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy"); //log4jdbc
        hikariConfig.setJdbcUrl(url+server+"/"+database+"?useSSL=false");
        hikariConfig.setUsername(user_name);
        hikariConfig.setPassword(password);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    /* MyBatis : Auto Connection close() */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
    }

}
