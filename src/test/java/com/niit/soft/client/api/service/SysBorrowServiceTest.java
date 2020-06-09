package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.SysBorrow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysBorrowServiceTest {

    @Resource
    private SysBorrowService sysBorrowService;
    @Test
    void findBorrowMessage() {
        ResponseResult result = sysBorrowService.findBorrowMessage("1802343116");
        System.out.println(result);
    }
}