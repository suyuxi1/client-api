package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class FleaRewardRepositoryTest {
    @Resource
    private FleaRewardRepository fleaRewardRepository;

    @Test
    void findAll(){
        System.out.println(fleaRewardRepository.findFleaRewardsByDescriptionLikeOrTitleLike("%牙%", "%牙%"));
    }
}