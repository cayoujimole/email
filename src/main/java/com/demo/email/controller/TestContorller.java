package com.demo.email.controller;

import com.demo.email.config.redis.RedisUtils;
import com.demo.email.dao.UserInfoMapper;
import com.demo.email.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sam
 * @since 2017/7/14
 */
@RestController
@Controller
public class TestContorller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/hello")
    public String index() {
        logger.info("xxxxxxxxxxxxxxxxxxxxxxxx");
        return "hello world !";
    }

    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo() {
        logger.info("xxxxxxxxxxxxxxxxxxxxxxxxgetUserInfo");
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey("8a808796458dcf5c01458dd0268b0002");
        return userInfo;
    }

    @Autowired
    protected RedisTemplate redisTemplate;

    /**
     * 提交代码
     * @return
     */
    @RequestMapping("/getRedis")
    public Object getRedis() {
        logger.info("xxxxxxxxxxxxxxxxxxxxxxxxgetRedis");
        redisTemplate.opsForValue().set("name","zdxvsdfsef");
        return redisTemplate.opsForValue().get("name");
    }
}
