package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.xml.transform.Source;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysBorrowServiceTest {

    @Resource
    private SysBorrowService sysBorrowService;

    @Test
    void findSysBorrowsByBorrowUserNumber() {
        ResponseResult result = sysBorrowService.findSysBorrowsByBorrowUserNumber("1802333117");
        System.out.println(result);
    }

    @Test
    void countByBooks() {
        ResponseResult result = sysBorrowService.countByBooks("1802333117");
        System.out.println(result);
    }
}