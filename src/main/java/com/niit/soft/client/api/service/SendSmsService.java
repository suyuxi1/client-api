package com.niit.soft.client.api.service;

import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 8:24
 * @Version 1.0
 **/
public interface SendSmsService {
    //发送验证码
     boolean send(String phoneNum, String templateCode, Map<String, Object> code);
    //校验验证码
     boolean verify(String phoneNum, String code);
}
