package com.wjt.springboot.service.impl;

import com.wjt.springboot.dao.SpringbootUserMapper;
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
    private SpringbootUserMapper springbootUserMapper;


    @Override
    @Transactional
    public void insert(SpringbootUser user)
    {
        springbootUserMapper.insert(user);
    }
}
