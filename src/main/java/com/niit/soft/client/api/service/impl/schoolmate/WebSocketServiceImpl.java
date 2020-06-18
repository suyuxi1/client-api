package com.niit.soft.client.api.service.impl.schoolmate;

import com.niit.soft.client.api.domain.model.schoolmate.Message;
import com.niit.soft.client.api.service.schoolmate.WebSocketService;
import com.niit.soft.client.api.util.RedisUtil;
import com.niit.soft.client.api.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WebSocketServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/6/17 9:35 上午
 * @Version 1.0
 **/
@Service
public class WebSocketServiceImpl implements WebSocketService {
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public void sendToUserByTemplate(Map<String, String> params) {
        String fromUserId = params.get("fromUserId");
        String toUserId = params.get("toUserId");
        String msg = "来自" + fromUserId + "消息:" + params.get("msg");
        String destination = "/topic/user" + toUserId;
        redisUtil.lSet(fromUserId + toUserId, Message.builder().pkMessageId(String.valueOf(new SnowFlake(1, 3).nextId()))
                .fromId(fromUserId).toId(toUserId)
                .content(msg)
                .destination(destination)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .build());
        template.convertAndSend(destination, msg);
    }

    @Override
    public List<Object> getAllMessage(String key) {
        return redisUtil.lGet(key, 0, -1);
    }
}
