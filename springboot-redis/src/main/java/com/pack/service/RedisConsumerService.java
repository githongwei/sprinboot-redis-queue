package com.pack.service;

/**
 * redis 消费者service
 * @author zhaoHongwei
 * @date 2019/10/21
 */
public interface RedisConsumerService {

    /**
     * 消费者
     * @param message
     */
    void receiveMessage(String message);

}
