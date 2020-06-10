package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.CollectionDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FleaCollectionServiceTest {
    @Resource
    private FleaCollectionService fleaCollectionService;
    @Test
    void addCollection() {
        CollectionDto collectionDto = CollectionDto.builder()
                .goodsId(1l)
                .userId(1l)
                .build();
        System.out.println(fleaCollectionService.addCollection(collectionDto));
    }
}