package com.niit.soft.client.api.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CollectionsMapperTest {

    @Resource
    private CollectionsMapper collectionsMapper;
    @Test
    void findCollectionsByUserId() {
        System.out.println(collectionsMapper.findCollectionsByDynamicId(1L));
    }
}