package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class RoomRepositoryTest {

    @Resource
    private RoomRepository roomRepository;

    @Test
    void findTowerNameById() {
        String towerName = roomRepository.findTowerNameById((long)1);
        System.out.println(towerName);
    }

    @Test
    void findLeaderNumberByName() {
        String jobNumber=roomRepository.findLeaderNumberByName("雪松苑-A4-113");
        System.out.println(jobNumber);
    }
}