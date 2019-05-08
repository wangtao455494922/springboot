package com.wjt.springboot.controller;

import com.wjt.springboot.model.SpringbootUser;
import com.wjt.springboot.service.SpringbootUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjt
 * @Description: 控制类
 * @date 2019/5/7 16:06
 */
@RestController
public class SpringbootUserController
{
    private final Logger logger = LoggerFactory.getLogger(SpringbootUserController.class);

    @Autowired
    private SpringbootUserService springbootUserService;

    @RequestMapping(value = "/insertUser")
    public String insertUser(){
        logger.debug("测试");
        SpringbootUser user = new SpringbootUser();
        user.setName("王金涛");
        springbootUserService.insert(user);
        return "添加成功";
    }
}
