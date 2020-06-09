package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.ReplyComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName ReplyCommentRepository
 * @Description TODO
 * @Date 2020/6/9  8:33
 * @Version 1.0
 **/
public interface ReplyCommentRepository extends JpaRepository<ReplyComment,Long> {

    /**
     * 更具用户id，删除
     * @param commentId
     * @param userId
     */
    @Transactional
    @Modifying
    @Query("delete from ReplyComment where pkReplyCommentId = ?1 and userId = ?2 ")
    void deleteByDynamicIdAndDynamicId(Long commentId,Long userId);

    /**
     * 更具评论id查找
     * @return
     */
    List<ReplyComment> findByCommentId(Long commentId);

    /**
     * 12
     * @param commentId
     */
    @Transactional
    @Modifying
    @Query("delete from ReplyComment where commentId = ?1  ")
    void deleteByCommentId(Long commentId);

}
