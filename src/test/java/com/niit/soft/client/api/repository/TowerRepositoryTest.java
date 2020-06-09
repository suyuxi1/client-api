package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@SpringBootTest
class TowerRepositoryTest {
    @Resource
    private  TowerRepository towerRepository;

    @Test
    void  deleteAll(){
        List<Long> ids = new ArrayList<Long>();
        for (int i = 1; i <= 38; i++) {
            ids.add((long) i);
        }
        ids.add((long) 1);
        towerRepository.deleteBatch(ids);
    }

    @Test
    void findBedRoom() {
        System.out.println(towerRepository.findBedRoom());
    }
}