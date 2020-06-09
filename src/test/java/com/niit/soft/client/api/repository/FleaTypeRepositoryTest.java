package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FleaTypeRepositoryTest {
    @Resource
    private FleaTypeRepository fleaTypeRepository;
    @Test
    void getGoodsByTypeId() {
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC,"goodsCreateTime");
        System.out.println(fleaTypeRepository.getGoodsByTypeId(pageable,2l));
    }
}