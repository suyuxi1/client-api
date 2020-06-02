package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class InfoTypeServiceTest {

    @Resource
    private InfoTypeService infoTypeService;

    @Test
    void getInfoByPkInfoTypeId() {
        ResponseResult result = infoTypeService.getInfoByPkInfoTypeId(1L);
        System.out.println(result);
    }
}