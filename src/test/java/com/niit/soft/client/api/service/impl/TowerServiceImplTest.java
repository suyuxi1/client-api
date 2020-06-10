package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.repository.TowerRepository;
import com.niit.soft.client.api.service.TowerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.persistence.Tuple;
import java.util.List;

@SpringBootTest
class TowerServiceImplTest {
    @Resource
    private TowerService towerService;

    @Resource
    private TowerRepository towerRepository;
    @Test
    void roomDtoList() {
        List<Tuple> tuples=towerRepository.findBedRoom();
        System.out.println(towerService.createVo(tuples));
    }
}