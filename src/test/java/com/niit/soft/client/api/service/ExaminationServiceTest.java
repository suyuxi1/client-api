package com.niit.soft.client.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExaminationServiceTest {

    @Resource
    private ExaminationService examinationService;

    @Test
    void selectAll() {
        examinationService.selectAll("1914866205").forEach(System.out::println);
    }
}