package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DynamicServiceTest {
    @Resource
    private DynamicService dynamicService;

    @Test
    void findDynamicVoById() {
    }

    @Test
    void findDynamicByPage() {
        System.out.println(dynamicService.findDynamicByPage(new PageDto(1, 1)));
    }
}