package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaCollection;
import com.niit.soft.client.api.domain.model.FleaComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName a.java
 * @Description TODO
 * @createTime 2020年06月09日 11:26:00
 */
public interface FleaCommentRepository extends JpaRepository<FleaComment,Long> {

    /**
     * 查询所有
     * @return List<FleaComment>
     */
    @Query(value = "select e from FleaComment e")
    List<FleaComment> selectAll();
}
