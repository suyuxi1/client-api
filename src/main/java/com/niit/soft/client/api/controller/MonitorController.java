//package com.niit.soft.client.api.controller;
//
//import com.niit.soft.client.api.websocket.SessionPool;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Map;
//
///**
// * @ClassName MonitorController
// * @Description TODO
// * @Author xiaobinggan
// * @Date 2020/6/11 8:26 上午
// * @Version 1.0
// **/
//@Controller
//public class MonitorController {
//
//    @ResponseBody
//    @GetMapping("/sendMessage")
//    public static String sendMessage(@RequestParam Map<String, Object> params) {
////        String msg = params.get("msg").toString();
//        SessionPool.sendMessage(params);
//        return "发送成功";
//    }
//
//    @GetMapping("/show")
//    public String show() {
//        return "/show.html";
//    }
//}
