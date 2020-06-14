package com.niit.soft.client.api.repository.schoolmate;

import com.niit.soft.client.api.domain.model.schoolmate.Collections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Yujie_Zhao
 * @ClassName Collections
 * @Description 收藏
 * @Date 2020/6/11  9:48
 * @Version 1.0
 **/

public interface CollectionsRepository extends JpaRepository<Collections,String> {
    /**
     * 分页查询动态的收藏
     * @param id
     * @param pageable
     * @return
     */
    @Query(value = "select * from first_smart_campus.collections where user_id = ?1 and is_deleted = 0  ",nativeQuery = true)
    Page<Collections> getCollectionsByUserId(String id,Pageable pageable);

}
