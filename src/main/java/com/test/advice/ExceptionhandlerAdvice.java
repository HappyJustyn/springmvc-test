package com.test.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Justyn
 * @date 2018/10/5 17:51
 */
@Slf4j
@ControllerAdvice
public class ExceptionhandlerAdvice {
    @ExceptionHandler(value = Exception.class)
    public void handler(Exception exception, WebRequest request) {
        log.error("系统异常:{}", exception);
    }
}
