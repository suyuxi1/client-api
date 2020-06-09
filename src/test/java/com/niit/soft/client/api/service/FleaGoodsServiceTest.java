package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.FleaGoodsDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
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

    @Test
    void findGoodById() {
        log.info(String.valueOf(fleaGoodsService.findGoodById(5L)));
    }

    @Test
    void updateGoodsMessage() {
        FleaGoodsDto fleaGoodsDto = FleaGoodsDto.builder()
                .pkFleaGoodsId(5L).goodsName("铁三角").goodsDescription("3D立体环绕，左右双声道").goodsImgUrl("music.jpg")
                .goodsPrice(200.00).goodsMark("电竞")
                .pkFleaUserId(2L).pkFleaTypeId(4L)
                .build();
        fleaGoodsService.updateGood(fleaGoodsDto);
        System.out.println(fleaGoodsService.findGoodById(5L));
    }

    @Test
    void soldOutGood() {
        System.out.println(fleaGoodsService.soldOutGood(false, 4L));
    }
}