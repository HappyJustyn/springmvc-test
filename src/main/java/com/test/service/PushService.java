package com.test.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Justyn
 * @date 2018/10/6 13:27
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAnsycUpdate() {
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    /**
     * 定时任务更新deferredResult，有数据更新时才会返回给客户端
     * 
     * @param 
     * @return 
     * @author Justyn
     * @date 2018/10/6 13:32
     */
    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (deferredResult != null) {
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
