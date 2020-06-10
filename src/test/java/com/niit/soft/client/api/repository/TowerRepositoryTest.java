package com.niit.soft.client.api.repository;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<Tuple> bedRooms = towerRepository.findBedRoom();
        bedRooms.stream().map(tuple -> {
            return tuple.get(0,String.class)+
                    tuple.get(1,String.class)+
                    tuple.get(2,String.class);
        }).forEach(System.out::println);

    }

    @Test
    void findBedRoomAll() {
        List<Map<String,Object>> towers = towerRepository.findBedRoomAll();
        System.out.println(JSON.toJSON(towers));

    }
}