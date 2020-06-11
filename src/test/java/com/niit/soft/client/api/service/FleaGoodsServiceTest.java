package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.FleaGoodsDto;
import com.niit.soft.client.api.domain.dto.SaveGoodDto;
import com.niit.soft.client.api.domain.vo.MarkVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/10
 */
@SpringBootTest
@Slf4j
class FleaGoodsServiceTest {
    @Resource
    private FleaGoodsService fleaGoodsService;

    @Test
    void saveGoods() {
        SaveGoodDto saveGoodDto = SaveGoodDto.builder()
                .pkFleaTypeId(2L).pkFleaUserId(3L).goodsName("中华2B铅笔").goodsDescription("绘画专用").goodsImgUrl("绘画.jpg")
                .goodsMark("艺术").goodsPrice(2.00)
                .build();
        log.info(String.valueOf(fleaGoodsService.saveGoods(saveGoodDto)));
    }

    @Test
    void findTopFiveMark() {
        System.out.println(fleaGoodsService.findTopFiveMark());
    }
}