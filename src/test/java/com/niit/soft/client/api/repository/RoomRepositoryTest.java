package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    }

    @Test
    void  saveall(){
        List<Room> roomList=new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
          Room room=
                  Room.builder().isDeleted(false).name("31"+i).gmtCreate(Timestamp.valueOf(LocalDateTime.now())).electricityBalance(12.0).unitId((long) 3).towerId((long) 1).build();
          roomList.add(room);
        }
        roomRepository.saveAll(roomList);
    }
}