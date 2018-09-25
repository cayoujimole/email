package com.demo.email.dao;

import com.demo.email.model.SendEmail;

public interface SendEmailMapper {
    int deleteByPrimaryKey(String id);

    int insert(SendEmail record);

    int insertSelective(SendEmail record);

    SendEmail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SendEmail record);

    int updateByPrimaryKey(SendEmail record);
}