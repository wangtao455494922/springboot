package com.wjt.springboot.dao;

import com.wjt.springboot.model.SpringbootUser;

public interface SpringbootUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpringbootUser record);

    int insertSelective(SpringbootUser record);

    SpringbootUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpringbootUser record);

    int updateByPrimaryKey(SpringbootUser record);
}