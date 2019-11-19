package com.pack.redis;


import com.pack.service.RedisConsumerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import javax.annotation.Resource;

/**
 * 消息监听容器及redis监听器注入IOC容器
 * @author admin
 */
@Configuration
public class RedisSubListenConfig {

    /**
     * 加载初始化容器
     */
    @Resource
    private RedisMessageListenerContainer container;

    /**
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息
     * 监听可以通过反射调用消息订阅处理器的相关方法进行一些业务处理
     * @param listenerAdapter
     * @return
     */
    @Bean
    RedisMessageListenerContainer listenerContainer(MessageListenerAdapter listenerAdapter){
        listenerAdapter.afterPropertiesSet();
        // 订阅一个叫 send_message 的通道
        container.addMessageListener(listenerAdapter,new PatternTopic("send_message"));
        // container 可以添加多个messageLister
        return container;
    }

    /**
     * 利用反射创建监听到的消息之后执行方法
     * @param redisConsumerService
     * @return
     */
    @Bean
    MessageListenerAdapter listenerAdapter(RedisConsumerService redisConsumerService){
        return new MessageListenerAdapter(redisConsumerService,"receiveMessage");
    }

}
