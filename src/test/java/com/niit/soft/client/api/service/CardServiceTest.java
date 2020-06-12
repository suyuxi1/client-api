package com.niit.soft.client.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CardServiceTest {

    @Resource
    private  CardService cardService;
    @Test
    void insertBalance() {
        System.out.println(cardService.insertBalance("1802343315",88.8));
    }
}