package com.niit.soft.client.api.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobTypeMapperTest {

    @Resource
    private JobTypeMapper jobTypeMapper;

    @Test
    void selectName() {
        System.out.println(jobTypeMapper.selectName("hdfskg"));
    }
}