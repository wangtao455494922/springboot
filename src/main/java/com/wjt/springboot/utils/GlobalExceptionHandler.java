package com.wjt.springboot.utils;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
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
    /*
    * 注意:如果是项目中存在的路径,可以捕获。
    *     ①返回提示语
    *     ②返回错误页面
    *
    * */
    @ExceptionHandler(value = RuntimeException.class)
   /* @ResponseBody*/
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        /*return "我是个异常处理类(存在路径)";*/
        return "/404";
    }

    /*
     * 注意:非项目中存在的路径,捕获不到。
     *     ①返回提示语
     *     ②返回错误页面
     *     根据实际情况定制返回类型
     *
     * */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        WebServerFactoryCustomizer<ConfigurableWebServerFactory>  result = factory ->
        {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            factory.addErrorPages(error404Page);
        };
        return  result;
    }
}
