package com.bitacademy.mysite.config;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.bitacademy.mysite.config.web.FileUploadConfig;
import com.bitacademy.mysite.config.web.MVCConfig;
import com.bitacademy.mysite.config.web.MessageResourceConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.bitacademy.mysite.controller", "com.bitacademy.mysite.exception"})
@Import({MVCConfig.class, SecurityConfig.class, FileUploadConfig.class, MessageResourceConfig.class})
public class WebConfig {
}