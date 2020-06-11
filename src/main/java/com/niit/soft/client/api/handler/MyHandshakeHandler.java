package com.niit.soft.client.api.handler;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

/**
 * @ClassName MyHandshakeHandler
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/6/10 3:36 下午
 * @Version 1.0
 **/
@Component
public class MyHandshakeHandler extends DefaultHandshakeHandler {


    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        // 验证用户信息是否合法有效
        return super.determineUser(request, wsHandler, attributes);
    }

}
