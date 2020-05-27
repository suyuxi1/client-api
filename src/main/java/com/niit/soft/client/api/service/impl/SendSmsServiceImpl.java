package com.niit.soft.client.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.niit.soft.client.api.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/21 10:26
 * @Version 1.0
 **/
@Service
public class SendSmsServiceImpl implements SendSmsService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean send(String phoneNum, String templateCode, Map<String, Object> code) {

        //连接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G3rkARQwiGGkprRZwGm", "Okx5ZZrlOveWo6WzQR3tHtCrDx5Mdq");
        IAcsClient client = new DefaultAcsClient(profile);
        //构建请求
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "智慧园区");
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));   //发送的验证码
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean verify(String phoneNum, String code) {
//        如果传来的验证码存在，通过验证
        if (code.equals(redisTemplate.opsForValue().get(phoneNum))) {
            return true;
        }else {
            return false;
        }
    }
}
