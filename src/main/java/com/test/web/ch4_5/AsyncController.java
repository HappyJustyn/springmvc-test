package com.test.web.ch4_5;

import com.test.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * 服务器推送-异步方法方式
 *
 * @author Justyn
 * @date 2018/10/6 13:22
 */
@Controller
public class AsyncController {

    @Autowired
    private PushService pushService;

    /**
     * 通过返回DeferredResult来实现
     * 
     * @param 
     * @return
     * @author Justyn
     * @date 2018/10/6 16:31
     */
    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredResult() {
        return pushService.getAnsycUpdate();
    }
}
