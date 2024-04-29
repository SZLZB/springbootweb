package com.bootweb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.context.FileEncodingApplicationListener;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classname: MyDatasoureConfig
 * Package: com.bootweb.config
 * Description:
 *
 * @Author: Simon
 * Create: 2024-03-24 - 09:28
 * Version: v1.0
 */
@Deprecated  //过时了
//@Configuration
public class MyDatasoureConfig {

    //默认是检查是否有数据源 没有才用自带的
   // @ConfigurationProperties("spring.datasource")
    //@Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //开启监控功能 可以去yaml设置
        //druidDataSource.setFilters("stat");//多个设置用逗号  只要用了set 都可以去配置文件配置
        return druidDataSource;
    }

    //druid监控页面
    //Alt+enter 然后回车 然后用键盘的上下键↓选择想要创建的对象名字即可
    //@Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet =   new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean =
                new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        //添加初始化参数
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","SYSDBA");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","123456");
        return statViewServletServletRegistrationBean;
    }

    //WebStatFilter 用来采集web-jdbc 关联监控数据
    //采集WEB应用数据
    //@Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<>(webStatFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));//拦截所有请求
        registrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");  //去除拦截的请求
        return registrationBean;

    }

    //防火墙配置

}
