package com.wjt.springboot.service.impl;

import com.wjt.springboot.dao.source1.SpringbootUserMapper1;
import com.wjt.springboot.dao.source2.SpringbootUserMapper2;
import com.wjt.springboot.model.SpringbootUser;
import com.wjt.springboot.service.SpringbootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wjt
 * @Description: 实现类
 * @date 2019/5/7 15:57
 */
@Service
public class SpringbootUserServiceImpl implements SpringbootUserService
{

    @Autowired
    private SpringbootUserMapper1 springbootUserMapper1;
    @Autowired
    private SpringbootUserMapper2 springbootUserMapper2;



    @Override
    @Transactional
    public void insert(SpringbootUser user)
    {
        SpringbootUser user1 = new SpringbootUser();
        user1.setName("我是用户1");
        springbootUserMapper1.insert(user1);
        int i =10/0;
        SpringbootUser user2 = new SpringbootUser();
        user2.setName("我是用户2");
        springbootUserMapper2.insert(user2);
    }
}
