package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FleaGoodsRepositoryTest {
    @Resource
    private FleaGoodsRepository fleaGoodsRepository;
    @Test
    void getAllGoodsByTime() {
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC,"goodsCreateTime");
        System.out.println(fleaGoodsRepository.getAllGoodsByTime(pageable));
    }
}