package com.niit.soft.client.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DynamicServiceTest {
    @Resource
    private DynamicService dynamicService;

    @Test
    void findPicture() {
        System.out.println(dynamicService.findPicture(1L));
    }
}