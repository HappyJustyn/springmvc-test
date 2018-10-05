package com.test;

import com.test.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
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
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 添加静态资源访问
     * 
     * @param 
     * @return 
     * @author Justyn
     * @date 2018/10/5 16:36
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 设置访问路径和静态资源路径
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    /**
     * 实现自定义拦截器
     *
     * @param 
     * @return 
     * @author Justyn
     * @date 2018/10/5 17:14
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    /**
     * 配置jsp页面跳转功能，省去在controller中进行跳转
     * 
     * @param 
     * @return 
     * @author Justyn
     * @date 2018/10/5 17:59
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/test");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/sse").setViewName("/sse");
    }

    /**
     * 文件上传配置
     * 
     * @param
     * @return 
     * @author Justyn
     * @date 2018/10/5 18:23
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }
}
