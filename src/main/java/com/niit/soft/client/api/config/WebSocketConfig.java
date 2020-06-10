package com.niit.soft.client.api.config;

import com.niit.soft.client.api.handler.MyHandshakeHandler;
import com.niit.soft.client.api.interceptor.AuthHandshakeInterceptor;
import com.niit.soft.client.api.interceptor.MyChannelInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

/**
 * @ClassName WebSocketConfig
 * @Description 配置WebSocket的config
 * @Author xiaobinggan
 * @Date 2020/6/10 3:17 下午
 * @Version 1.0
 **/
@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Autowired
    private MyChannelInterceptor inboundChannelInterceptor;

    @Autowired
    private AuthHandshakeInterceptor authHandshakeInterceptor;

    @Autowired
    private MyHandshakeHandler myHandshakeHandler;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableStompBrokerRelay("/topic", "/queue")
                // rabbitmq-host服务器地址
                .setRelayHost("localhost")
                // rabbitmq-stomp 服务器服务端口
                .setRelayPort(5672)
                // 登陆账户
                .setClientLogin("guest")
                // 登陆密码
                .setClientPasscode("guest");
        //定义一对一推送的时候前缀
        registry.setUserDestinationPrefix("/user/");
        //客户端需要把消息发送到/message/xxx地址
        registry.setApplicationDestinationPrefixes("/message");
        log.info("init rabbitmq websocket MessageBroker complated.");
    }

    /**
     * 连接站点配置
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*")
                .setHandshakeHandler(myHandshakeHandler)
                .addInterceptors(authHandshakeInterceptor)
                .withSockJS();
        log.info("init rabbitmq websocket endpoint ");
    }


    /**
     * 输入通道配置
     *
     * @param registration
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(inboundChannelInterceptor);
        // 线程信息
        registration.taskExecutor()
                // 核心线程池
                .corePoolSize(400)
                // 最多线程池数
                .maxPoolSize(800)
                // 超过核心线程数后，空闲线程超时60秒则杀死
                .keepAliveSeconds(60);
    }

    /**
     * 消息传输参数配置
     *
     * @param registration
     */
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        // 超时时间
        registration.setSendTimeLimit(15 * 1000)
                // 缓存空间
                .setSendBufferSizeLimit(512 * 1024)
                // 消息大小
                .setMessageSizeLimit(128 * 1024);
    }


}