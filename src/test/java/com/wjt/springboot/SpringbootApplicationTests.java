package com.wjt.springboot;

import com.wjt.springboot.dao.SpringbootUserMapper;
import com.wjt.springboot.model.SpringbootUser;
import com.wjt.springboot.service.SpringbootUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests
{
    @Autowired
    private SpringbootUserMapper springbootUserMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private SpringbootUserService springbootUserService;


    @Test
    public void insertUser(){
        SpringbootUser user = new SpringbootUser();
        user.setName("wangjintao");
        springbootUserMapper.insert(user);
    }

    @Test
    public void testRedis() throws Exception {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("name", "wangjintao");
        String value = ops.get("name");
        System.out.println(value);
    }

    @Test
    public void testAtomikos(){
        springbootUserService.addUser();
        System.out.println("添加完成");
    }


}
