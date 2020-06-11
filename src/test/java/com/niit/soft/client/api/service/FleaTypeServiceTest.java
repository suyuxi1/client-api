package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.dto.TypeDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FleaTypeServiceTest {
    @Resource
    private FleaTypeService typeService;
    @Test
    void getGoodsByType() {
        TypeDto typeDto = TypeDto.builder()
                .currentPage(0)
                .pageSize(2)
                .typeId(2l)
                .build();
        System.out.println(typeService.getGoodsByType(typeDto));
    }
}