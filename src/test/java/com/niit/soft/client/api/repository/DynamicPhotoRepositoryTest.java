package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DynamicPhotoRepositoryTest {
    @Resource
    private DynamicPhotoRepository dynamicPhotoRepository;

    @Test
    void findDistinctByDynamicId() {
        List<String> dynamicPhotoList = dynamicPhotoRepository.findDistinctByDynamicId(1L);
        System.out.println(dynamicPhotoList);
    }
}