package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CollectionsRepositoryTest {
    @Resource
    private CollectionsRepository collectionsRepository;

    @Test
    void findCollectionsByUserId() {

    }

    @Test
    void getCollectionsByUserId() {
    }

    @Test
    void findCollectionsByUserIdAndDynamicId() {
        Collections collections = collectionsRepository.findCollectionsByUserIdAndDynamicIdAndIsDeleted(1L, 2L,false);
        System.out.println(collections ==null );
    }

    @Test
    void updateCollectionsIsDelete() {
        Collections collections = collectionsRepository.findCollectionsByPkCollectionId(54901532302643200L);
        collections.setIsDeleted(true);
        collectionsRepository.saveAndFlush(collections);
    }
}