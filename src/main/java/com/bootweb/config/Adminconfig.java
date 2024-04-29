package com.bootweb.config;

import com.bootweb.demos.web.loginintercet;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classname: Adminconfig
 * Package: com.bootweb.config
 * Description:
 *
 * @Author: Simon
 * Create: 2024-03-06 - 11:05
 * Version: v1.0
 */

@Configuration
public class Adminconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginintercet()) //添加拦截器
                //.addPathPatterns("/**")              //拦截所有请求  注意包括了静态资源 比如css js image等
                .addPathPatterns("/**/*.do")           //精确拦截所有请求后缀围殴.do
                .excludePathPatterns("/tologin")    //放行请求
                .excludePathPatterns("/login")
                .excludePathPatterns("/sql.do")
                .excludePathPatterns("/zg.do")
                .excludePathPatterns("/msg.do")
                .excludePathPatterns("/Csgit.do");
    }


}
