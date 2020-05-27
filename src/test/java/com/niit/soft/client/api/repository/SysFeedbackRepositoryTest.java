package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.SysFeedback;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SysFeedbackRepositoryTest {
    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    @Test
    void name() {
        SysFeedback sysFeedback = SysFeedback.builder()
                .title("测试标题")
                .content("测试内容")

                .contactWay("17826012341")
                .build();
        sysFeedbackRepository.save(sysFeedback);
    }




}