package com.demo.email.dao;

import com.demo.email.model.ReceiveEmail;

public interface ReceiveEmailMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReceiveEmail record);

    int insertSelective(ReceiveEmail record);

    ReceiveEmail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReceiveEmail record);

    int updateByPrimaryKey(ReceiveEmail record);
}