package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAccountServiceTest {

    @Resource
    private UserAccountService userAccountService;
    @Test
    void findUserAccountLike() {
        ResponseResult result = userAccountService.findUserAccountLike("曹");
        System.out.println(result);
    }
}