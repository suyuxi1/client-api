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
        String jobNumber=roomRepository.findLeaderNumberByName("雪松苑-A4-113");
        System.out.println(jobNumber);
    }

    @Test
    void  saveall(){
        List<Room> roomList=new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
          Room room=
                  Room.builder().isDeleted(false).name("海棠院"+"-"+"C13"+"-"+11+i).gmtCreate(Timestamp.valueOf(LocalDateTime.now())).electricityBalance(0.0).towerId((long) 1).build();
          roomList.add(room);
        }
        roomRepository.saveAll(roomList);
    }
}