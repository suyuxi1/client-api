package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CardServiceImplTest {
    @Resource
    private CardService cardService;

    @Test
    void insertelectricityBalance() {
   ResponseResult a=     cardService.insertelectricityBalance("雪松苑-A4-113",100.0);
        System.out.println(a);

    }
}