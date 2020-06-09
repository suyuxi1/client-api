package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaCollection;
import com.niit.soft.client.api.domain.model.FleaComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FleaCommentRepository extends JpaRepository<FleaComment,Long> {

    /**
     * 查询所有
     * @return List<FleaComment>
     */
    @Query(value = "select e from FleaComment e")
    List<FleaComment> selectAll();
}
