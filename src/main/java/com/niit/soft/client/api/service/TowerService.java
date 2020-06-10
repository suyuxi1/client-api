package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.RoomDto;

import javax.persistence.Tuple;
import java.util.List;

/**
 * @ClassName TowerService
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/9
 **/
public interface TowerService {

    List<RoomDto> createVo(List<Tuple> roomList);
}