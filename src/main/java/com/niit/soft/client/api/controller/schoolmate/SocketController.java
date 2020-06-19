package com.niit.soft.client.api.controller.schoolmate;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * websocket Controller
 *
 * @author yy
 */
@Slf4j
@RestController
@RequestMapping("/wechat")
@Api(tags = "微信消息推送的接口")
public class SocketController {


    private final RestTemplate restTemplate;
    @Autowired
    SimpMessageSendingOperations simpMessageSendingOperations;
    @Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.secret}")
    private String secret;

    @Autowired
    public SocketController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/openid")
    public String openid(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        return response.getBody();
    }

    /**
     * 接收客户端发来的消息
     */
    @MessageMapping("/message")
    public void handleSubscribe(String msg) {
        log.info("客户端发来消息：" + msg);
        JSONObject json = JSONObject.parseObject(msg);
        String to = json.getString("to");
        if (!StringUtils.isEmpty(to)) {
            simpMessageSendingOperations.convertAndSendToUser(to, "/message", msg);
        }
    }

    /**
     * 客户端发送群聊消息
     */
    @MessageMapping("/chat-group.{roomId}")
    public void handleGroupMsg(@DestinationVariable String roomId, String msg) {
        log.info("房间号是：{}", roomId);
        log.info("群聊客户端发来消息：" + msg);
        simpMessageSendingOperations.convertAndSend("/topic/chat-group." + roomId, msg);
    }
}