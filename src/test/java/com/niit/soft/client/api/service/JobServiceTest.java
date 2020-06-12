package com.niit.soft.client.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobServiceTest {

    @Resource
    private JobService jobService;

    @Test
    void find() {
        jobService.find("max").forEach(System.out::println);
    }
}