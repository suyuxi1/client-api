package com.niit.soft.client.api.websocket;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SessionPool
 * @Description 会话连接池
 * @Author xiaobinggan
 * @Date 2020/6/11 8:22 上午
 * @Version 1.0
 **/
public class SessionPool {

    public static Map<String, Session> sessions = new ConcurrentHashMap<String, Session>();

    public static void close(String sessionId) throws IOException {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.get(sessionId).close();
        }
    }

    public static void sendMessage(String sessionId, String message) {
        sessions.get(sessionId).getAsyncRemote().sendText(message);
    }

    public static void sendMessage(String message) {
        for (String sessionId : SessionPool.sessions.keySet()) {
            SessionPool.sessions.get(sessionId).getAsyncRemote().sendText(message);
        }
    }

    public static void sendMessageByUserId(String userId, String message) {
        Session session = SessionPool.sessions.get(userId);
        if (session != null && session.isOpen()) {
            session.getAsyncRemote().sendText(message);
        }
    }

    public static void sendMessage(Map<String, Object> params) {
        String msg = params.get("msg").toString();
        String fromUserId = params.get("fromUserId").toString();

        // 用户一对一发送
        if (params.get("toUserId") != null && !params.get("toUserId").equals("")) {
            String touserId = params.get("toUserId").toString();
            msg = String.format("来自用户%s发送给用户%s,消息:%s", fromUserId, touserId, msg);
            sendMessageByUserId(touserId, msg);
        }
        // 群发
        else {
            msg = String.format("来自用户%s,消息:%s", fromUserId, msg);
            sendMessage(msg);
        }

    }
}
