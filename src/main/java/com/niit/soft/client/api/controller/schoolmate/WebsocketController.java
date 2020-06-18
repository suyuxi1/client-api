package com.niit.soft.client.api.controller.schoolmate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName WebsocketController
 * @Description 信息发送控制器
 * @Author xiaobinggan
 * @Date 2020/6/11 11:10 上午
 * @Version 1.0
 **/
@RestController
public class WebsocketController {
    @Autowired
    private SimpMessagingTemplate template;

//    /**
//     * exchange交换机模式 需要手动添加exchange，需要在config中加入enableStompBrokerRelay的前缀
//     *
//     * @param params
//     */
//    @MessageMapping("/sendToUser")
//    public void sendToUserByTemplate(Map<String, String> params) {
//        String fromUserId = params.get("fromUserId");
//        String toUserId = params.get("toUserId");
//        String msg = "来自" + fromUserId + "消息:" + params.get("msg");
//        String destination = "/exchange/sendToUser/user" + toUserId;
//        template.convertAndSend(destination, msg);
//    }

//    /**
//     * queue 自动创建queue，使用rabbitmq自带交换机
//     *
//     * @param params
//     */
//    @MessageMapping("/sendToUser")
//    public void sendToUserByTemplate(Map<String, String> params) {
//        String fromUserId = params.get("fromUserId");
//        String toUserId = params.get("toUserId");
//        String msg = "来自" + fromUserId + "消息:" + params.get("msg");
//        String destination = "/queue/user" + toUserId;
//        template.convertAndSend(destination, msg);
//    }


    /**
     * topic
     *
     * @param params
     */
    @MessageMapping("/sendToUser")
    public void sendToUserByTemplate(Map<String, String> params) {
        String fromUserId = params.get("fromUserId");
        String toUserId = params.get("toUserId");
        String msg = "来自" + fromUserId + "消息:" + params.get("msg");
        String destination = "/topic/user" + toUserId;
        template.convertAndSend(destination, msg);
    }

    @MessageMapping("/sendToAll")
    public void sendToAll(String msg) {
        String destination = "/topic/chat";
        template.convertAndSend(destination, msg);
    }

//    @MessageMapping("/sendToAll")
//    public void sendToAll(String msg) {
//        String destination = "/topic/chat";
//        template.convertAndSend(destination, msg);
//    }

    //    /**
//     * 轮询的发送，统一订阅queue自动生成
//     *
//     * @param msg
//     */
//    @MessageMapping("/sendToAll")
//    public void sendToAll(String msg) {
//        String destination = "/queue/chat";
//        template.convertAndSend(destination, msg);
//    }


    //    // return的msg返回到/sendToAll主题
//    @MessageMapping("/sendToAll")
//    public String sendToAll(String msg) {
//        return msg;
//    }
//
//    //收到/send消息
//    @MessageMapping("/send")
//    //分发到订阅过/topic的客户端上
//    @SendTo("/topic")
//    public String say(String msg) {
//        return msg;
//    }
//
//    @MessageMapping("/sendToUser")
//    public void sendToUserByTemplate(Map<String, String> params) {
//        String fromUserId = params.get("fromUserId");
//        String toUserId = params.get("toUserId");
//        String msg = "来自" + fromUserId + "消息:" + params.get("msg");
//
//        template.convertAndSendToUser(toUserId, "/topic", msg);
//    }
//
//    @GetMapping("/sendToAllByTemplate")
//    @MessageMapping("/sendToAllByTemplate")
//    public void sendToAllByTemplate(@RequestParam String msg) {
//        template.convertAndSend("/topic", msg);
//    }
//
//    // 发送到相应主题上，需要前端订阅该主题 推荐使用
    @GetMapping("/send")
    public String msgReply(@RequestParam String msg) {
        template.convertAndSend("/topic", msg);

        //可以不用返回值
        return msg;
    }


}
