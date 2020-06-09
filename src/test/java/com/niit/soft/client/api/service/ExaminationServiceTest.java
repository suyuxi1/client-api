package com.niit.soft.client.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/8
 * @Version 1.0
 */
@SpringBootTest
class ExaminationServiceTest {
    @Resource
    private ExaminationService examinationService;

    @Test
    void getExaminationBySemester() {
        List<Map<String, Object>> results = examinationService.getExaminationBySemester("1802333118");
        results.forEach(result -> {
            System.out.println(result);
        });
    }
}