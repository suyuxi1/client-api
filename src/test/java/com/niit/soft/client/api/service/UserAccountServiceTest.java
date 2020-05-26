package com.niit.soft.client.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserAccountServiceTest {

    @Resource
    private UserAccountService userAccountService;
    @Test
    void findUserAccountById() {
        System.out.println(userAccountService.findUserAccountById(1L));
    }
}