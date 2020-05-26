package com.niit.soft.client.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/24 10:27
 * @Version 1.0
 **/
@Slf4j
@RestController("/user/")
public class LoginController {
//    @PostMapping("/login")
//    public String login(@RequestBody User user) throws UnsupportedEncodingException {
//        log.info(JwtUtil.sign(user.getUsername(), user.getPassword()));
//        return "进入登录页面";
//    }


    @GetMapping("/index")
    public String index() {
        return "进入首页";
    }

    @GetMapping("/other")
    public String other() {
        return "进入功能页";
    }

}
