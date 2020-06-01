package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class SysSemesterServiceTest {

    @Resource
    private SysSemesterService sysSemesterService;

    @Test
    void findAllSysSemester() {
        ResponseResult result = sysSemesterService.findAllSysSemester();
        System.out.println(result);
    }
}