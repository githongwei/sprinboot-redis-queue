package com.pack.service.impl;

import com.pack.service.RedisConsumerService;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class RedisConsumerServiceImpl implements RedisConsumerService{

    @Override
    public void receiveMessage(String message) {
        System.out.println("接收到消息了:"+message);
    }
}
