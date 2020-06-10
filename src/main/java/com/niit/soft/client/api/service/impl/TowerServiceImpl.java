package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.domain.dto.RoomDto;
import com.niit.soft.client.api.repository.TowerRepository;
import com.niit.soft.client.api.service.TowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TowerServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/9
 **/
@Service
public class TowerServiceImpl implements TowerService {
    @Resource
    private TowerRepository towerRepository;

    @Override
    public List<RoomDto> createVo(List<Tuple> roomList) {
        List<Tuple> list =towerRepository.findBedRoom();
        List<RoomDto> roomDtoList=new ArrayList<>(10);
        //根据科目id、房间id、教工号id 取出需要的数据
        roomList.forEach((item)->{
            RoomDto roomDto=new RoomDto();
            roomDto.setTowerName(list.get(0).get(0,String.class));
            roomDto.setTowerUnitName(list.get(0).get(1,String.class));
            roomDto.setRoomName(list.get(0).get(2,String.class));
            roomDtoList.add(roomDto);
        });
        return roomDtoList;
    }

}