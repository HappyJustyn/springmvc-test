package com.test.web;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Justyn
 * @date 2018/9/27 10:33
 */
@Controller
public class HelloController {
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello() {
        return "test";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file) {
        try {
            FileUtils.writeByteArrayToFile(new File("d:/"+file.getOriginalFilename()),
                    file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
