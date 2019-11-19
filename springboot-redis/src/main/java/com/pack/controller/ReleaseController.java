package com.pack.controller;

import com.pack.redis.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author admin
 */
@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String sendMessage(){
        try {
            redisTemplate.convertAndSend("send_message","123456");
            redisUtil.set("wangfeng","小熊熊要乖哦");
            return "消息发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败！！！！";
        }
    }

}
