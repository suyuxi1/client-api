package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysCourseServiceTest {
    @Resource
    private SysCourseService sysCourseService;

    @Test
    void findTodayCourseTable() {
        ResponseResult result = sysCourseService.findTodayCourseTable((long)1);
        System.out.println(result);
    }
}