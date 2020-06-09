package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FleaGoodsServiceTest {
    @Resource
    private FleaGoodsService fleaGoodsService;
    @Test
    void getGoodsByTime() {
        PageDto pageDto = new PageDto();
        pageDto.setCurrentPage(0);
        pageDto.setPageSize(1);
        System.out.println(fleaGoodsService.getGoodsByTime(pageDto));
    }
}