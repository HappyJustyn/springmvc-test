package com.test.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * 服务器推送-浏览器方式
 *
 * @author Justyn
 * @date 2018/10/5 20:30
 */
@Controller
public class SseController {

    /**
     * produces = "text/event-stream"开启sse支持
     * 
     * @param 
     * @return 
     * @author Justyn
     * @date 2018/10/5 20:37
     */
    @RequestMapping(value = "/push", produces = "text/event-stream")
    @ResponseBody
    public String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 有数据更新时才会返回给客户端
        return "data:Testing 1,2,3" + r.nextInt() + "\n\n";
    }
}
