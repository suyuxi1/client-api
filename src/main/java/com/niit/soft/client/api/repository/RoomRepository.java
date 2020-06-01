package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tao
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

    /**
     * 根据房间名查询name
     * @param roomId
     * @return
     */
    @Query(value = "select name from room as r where r.id=?1",nativeQuery = true)
    String findTowerNameById(Long roomId);
}
