package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.DynamicCollectionInDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CollectionsServiceTest {

    @Resource
    private CollectionsService collectionsService;

    @Test
    void findCollections() {
    }

    @Test
    void getCollectionsByUserId() {
        PageDto pageDto = PageDto.builder()
                .currentPage(0)
                .pageSize(2)
                .field("1")
                .build();
        ResponseResult result = collectionsService.getCollectionsByUserId(pageDto);
        System.out.println(result);
    }

    @Test
    void insertCollections() {
        DynamicCollectionInDto dynamicCollectionInDto = DynamicCollectionInDto.builder()
                .userId(1L)
                .dynamicId(2L)
                .build();
        collectionsService.insertCollections(dynamicCollectionInDto);
    }

    @Test
    void updateCollectionsIsDelete() {
        collectionsService.updateCollectionsIsDelete(54901532302643200L);
    }
}