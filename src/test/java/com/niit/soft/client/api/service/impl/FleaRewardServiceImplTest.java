package com.niit.soft.client.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.niit.soft.client.api.domain.dto.FleaRewardDto;
import com.niit.soft.client.api.domain.dto.SingleFieldDto;
import com.niit.soft.client.api.service.FleaRewardService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaRewardServiceImplTest.java
 * @Description TODO
 * @createTime 2020年06月11日 11:43:00
 */
@SpringBootTest
class FleaRewardServiceImplTest {
    @Resource
    FleaRewardService fleaRewardService;

    @Test
    void save() {
        FleaRewardDto fleaRewardDto = JSON.parseObject("{\n" +
                "  \"pkRewardId\": 1,\n" +
                "  \"description\": \"dezxzmxknzkxnzmoData\",\n" +
                "  \"imageUrl\": \"demoData\",\n" +
                "  \"title\": \"demoData\",\n" +
                "  \"fleaUserId\": 1\n" +
                "}", FleaRewardDto.class);
        fleaRewardService.save(fleaRewardDto);
    }

    @Test
    void update() {
        FleaRewardDto fleaRewardDto = JSON.parseObject("{\n" +
                "  \"pkRewardId\": 5,\n" +
                "  \"description\": \"啊啊\",\n" +
                "  \"imageUrl\": \"demoData\",\n" +
                "  \"title\": \"demoData\",\n" +
                "  \"fleaUserId\": 1\n" +
                "}", FleaRewardDto.class);
        fleaRewardService.update(fleaRewardDto);
    }

    @Test
    void delete() {
        fleaRewardService.delete(7L);
    }
}