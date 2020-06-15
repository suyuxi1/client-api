package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PartJobServiceTest {

    @Resource
    private PartJobService partJobService;

    @Test
    void findAllByPage() {
//        PageDto pageDto = PageDto.builder()
//                .field("pay")
//                .currentPage(1)
//                .pageSize(10)
//                .build();
//        System.out.println(partJobService.findAllByPage(pageDto));
    }

    @Test
    void findByPage() {
        PageDto pageDto = PageDto.builder()
                .field("pay")
                .currentPage(1)
                .pageSize(10)
                .build();
        System.out.println(partJobService.findByPage(pageDto));
    }
}