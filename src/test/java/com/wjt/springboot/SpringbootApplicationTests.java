package com.wjt.springboot;

import com.wjt.springboot.model.SpringbootUser;
import com.wjt.springboot.service.SpringbootUserService;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests
{
    private final Logger logger = LoggerFactory.getLogger(SpringbootApplicationTests.class);

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private SpringbootUserService springbootUserService;

    /**
     *
     *
     *创建文章
     *
     * **/
    @Test
    public void testRedis() throws Exception {
        HashOperations<String, Object, Object> redisHash = redisTemplate.opsForHash();
        SetOperations<String, Object> redisSet = redisTemplate.opsForSet();
        ZSetOperations<String, Object> redisZset = redisTemplate.opsForZSet();

        long now = System.currentTimeMillis();
        //文章投票人
        String voted = "voted:001";
        String userId = "user:001";
        String title ="article:001";
        Long result = redisSet.add(voted, userId);

        //文章表
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("userId",userId);
        map.put("now",String.valueOf(now));
        map.put("votes",1l);
        redisHash.putAll(title,map);

        //评分表
        redisZset.add("sroce:info",title,now+400);

        //时间表
        redisZset.add("time:info",title,now);

        logger.info("---------------------------------Redis添加成功-------------------------"+result);
    }

    @Test
    public void testTou(){
        SetOperations<String, Object> redisSet = redisTemplate.opsForSet();
        ZSetOperations<String, Object> redisZset = redisTemplate.opsForZSet();
        HashOperations<String, Object, Object> redisHash = redisTemplate.opsForHash();

        Double zset = redisZset.score("time:info", "article:001");
        logger.info("------------------获取时间------------------------"+zset);

        //文章投票
        //Long res = redisSet.add("voted:001", "user:003");
        //logger.info("-----投票是否成功-----"+res);
        if ( redisSet.add("voted:001", "user:002")==1){
            //文章得分累加
            redisZset.incrementScore("sroce:info","article:001",400);
            redisHash.increment("article:001","votes",1l);

        }


    }
    /**
     *
     *
     * 多数据源测试
     *   Atomikos
     *
     *
     * **/
    @Test
    public void testAtomikos(){
        springbootUserService.insert(new SpringbootUser());
        logger.info("-------------添加完成------------------------------");
    }


}
