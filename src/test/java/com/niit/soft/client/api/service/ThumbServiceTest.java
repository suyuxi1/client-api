package com.niit.soft.client.api.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niit.soft.client.api.domain.model.Thumb;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ThumbServiceTest {
    @Resource
    private ThumbService thumbService;

    @Test
    void list() {
        System.out.println(thumbService.list(new QueryWrapper<Thumb>().eq("dynamic_id","55261698550272000")));
    }
}