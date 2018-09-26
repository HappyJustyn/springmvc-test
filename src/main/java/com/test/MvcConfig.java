package com.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Justyn
 * @date 2018/9/26 17:28
 */
// Spring会自动扫描包下面的@Configuration注解的配置类来装配
@Configuration
@EnableWebMvc
public class MvcConfig {
}
