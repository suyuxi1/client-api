package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Dynamic;
import com.niit.soft.client.api.util.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DynamicRepositoryTest {

    @Resource
    private DynamicRepository dynamicRepository;

    @Test
    void save() {
        dynamicRepository.save(Dynamic.builder().pkDynamicId(new SnowFlake(1, 3).nextId())
                .title("今天也是美好一天").content("开开心心").comments(0).thumbs(0).type("心情").userId(2L)
                .build());
    }

    @Test
    void select() {
        dynamicRepository.findAll().forEach(System.out::println);
    }
}