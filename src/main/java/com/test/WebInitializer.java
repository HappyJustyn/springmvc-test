package com.test;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * @author Justyn
 * @date 2018/9/27 10:00
 */
// WebApplicationInitializer是Spring提供用来配置Servlet3+的接口，从而实现替代web.xml
// 在Servlet3.0+中web容器启动时，会扫描类路径下所有的WebApplicationInitializer接口的实现类
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 加载配置类及初始化容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 注册配置类
        context.register(MvcConfig.class);
        // 和servletContext关联
        context.setServletContext(servletContext);
        // 注册Spring MVC的DispatcherServlet
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
