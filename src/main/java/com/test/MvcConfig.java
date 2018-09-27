package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Justyn
 * @date 2018/9/26 17:28
 */
// Spring会自动扫描包下面的@Configuration注解的配置类来装配
@Configuration
// @EnableWebMvc注解用于启动Spring MVC特性，类似<mvc:annotation-driven/>，
// 会在Spring中注册一些组件来提供最基本的MVC功能
@EnableWebMvc
@ComponentScan("com.test")
public class MvcConfig {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // 和开发目录不同，运行时自动编译到/WEB-INF/classes/views目录下
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
}
