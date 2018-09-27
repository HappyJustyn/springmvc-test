package com.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Justyn
 * @date 2018/9/27 10:33
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello() {
        return "index";
    }
}
