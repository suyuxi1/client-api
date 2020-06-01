package com.niit.soft.client.api.service;

import com.alipay.api.AlipayApiException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class AliPayServiceTest {
@Resource
private  AliPayService aliPayService;
    @Test
    void aliPay() throws AlipayApiException {
        System.out.println(aliPayService.AliPay(0.01));
    }
}