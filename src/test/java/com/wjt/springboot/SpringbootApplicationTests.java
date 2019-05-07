package com.wjt.springboot;

import com.wjt.springboot.dao.SpringbootUserMapper;
import com.wjt.springboot.model.SpringbootUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests
{

    @Autowired
    SpringbootUserMapper springbootUserMapper;

    @Test
    public void insertUser(){
        SpringbootUser user = new SpringbootUser();
        user.setName("王金涛");
        springbootUserMapper.insert(user);
    }
}
