package com.wjt.springboot.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wjt
 * @Description: 全局异常捕获
 * @date 2019/5/7 16:03
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        return "我是个异常处理类";
    }
}
