package com.test.web.ch4_6;

import com.test.MvcConfig;
import com.test.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Justyn
 * @date 2018/10/6 21:56
 */
// JUnit环境下的测试
@RunWith(SpringJUnit4ClassRunner.class)
// 用来加载ApplicationContext，class属性指定配置类
@ContextConfiguration(classes = {MvcConfig.class})
// 声明加载的是一个WebApplicationContext，value属性指定资源文件位置
@WebAppConfiguration
public class TestController {
    /**
     * 模拟MVC对象
     */
    private MockMvc mockMvc;

    @Autowired
    private DemoService demoService;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private MockHttpSession session;
    @Autowired
    private MockHttpServletRequest request;

    /**
     * 测试开始之前的操作
     *
     * @author Justyn
     * @date 2018/10/6 22:27
     */
    @Before
    public void setup() {
        // 初始化MVC对象
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNormalController() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
