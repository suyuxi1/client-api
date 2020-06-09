package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class FleaCollectionRepositoryTest {

    @Resource
    private FleaCollectionRepository fleaCollectionRepository;

    @Test
    void findAll(){
        System.out.println(fleaCollectionRepository.findAll());
    }
}