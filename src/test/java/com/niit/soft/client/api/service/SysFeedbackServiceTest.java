package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.SysFeedback;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysFeedbackServiceTest {

    @Resource
    private SysFeedbackService sysFeedbackService;

    @Test
    void insertSysFeedback() {
        SysFeedback sysFeedback = SysFeedback.builder()
                .title("测试标题")
                .content("测试内容")
                .contactWay("19996012341")
                .build();
       ResponseResult result = sysFeedbackService.insertSysFeedback(sysFeedback);
        System.out.println(result);
    }
}