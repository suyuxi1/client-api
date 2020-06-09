package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.Comment;

/**
 * @author Yujie_Zhao
 * @ClassName CommentService
 * @Description 评论
 * @Date 2020/6/8  16:21
 * @Version 1.0
 **/
public interface CommentService {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    ResponseResult insertComment(Comment comment);

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    ResponseResult deleteComment(Long commentId);
}
