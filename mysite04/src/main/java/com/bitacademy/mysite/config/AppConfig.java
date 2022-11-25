package com.bitacademy.mysite.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.bitacademy.mysite.config.app.DBConfig;
import com.bitacademy.mysite.config.app.MyBatisConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.bitacademy.mysite.service", "com.bitacademy.mysite.repository" ,"com.bitacademy.mysite.aspect"})
@Import({DBConfig.class,MyBatisConfig.class})
public class AppConfig {
}
