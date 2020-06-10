package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.xml.transform.Source;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TowerServiceTest {

    @Resource
    private TowerService towerService;

    @Test
    void getAllDormByType() {
        ResponseResult result = towerService.getAllDormByType();
        System.out.println(result);
    }
}