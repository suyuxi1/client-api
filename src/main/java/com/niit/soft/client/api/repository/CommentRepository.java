package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yujie_Zhao
 * @ClassName CommentRepository
 * @Description 评论
 * @Date 2020/6/8  16:20
 * @Version 1.0
 **/
public interface CommentRepository extends JpaRepository<Comment,Long> {

    /**
     * 根据动态id查询评论
     * @param dynamicId
     * @return
     */
    Comment findCommentByDynamicId(Long dynamicId);
}
