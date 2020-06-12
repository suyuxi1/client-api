package com.niit.soft.client.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;


@Controller
@Slf4j
public class ReceiveController {


    @MessageMapping("/client")
    public void all(String message) {
        log.info("*** 来自客户端的消息 ***:" + message);
    }
}
