package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.ReplyCommentDto;

/**
 * @author Yujie_Zhao
 * @ClassName ReplyCommentService
 * @Description 评论的评论
 * @Date 2020/6/9  8:36
 * @Version 1.0
 **/
public interface ReplyCommentService {
    /**
     * 添加
     * @param replyCommentDto
     * @return
     */
    ResponseResult insertReplyComment(ReplyCommentDto replyCommentDto);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deleteReplyComment(Long id);

}
