package com.niit.soft.client.api.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

/**
 * @ClassName WebSocketEndpoint
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/6/10 8:43 下午
 * @Version 1.0
 **/
@Component
public class WebSocketEndpoint {
    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     *
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {

    }
}
