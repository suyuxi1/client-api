package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.Dynamic;
import com.niit.soft.client.api.domain.model.ReplyComment;
import com.niit.soft.client.api.repository.CommentRepository;
import com.niit.soft.client.api.repository.DynamicRepository;
import com.niit.soft.client.api.repository.ReplyCommentRepository;
import com.niit.soft.client.api.service.ReplyCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yujie_Zhao
 * @ClassName ReplyCommentServiceImpl
 * @Description TODO
 * @Date 2020/6/9  9:59
 * @Version 1.0
 **/
@Service
public class ReplyCommentServiceImpl implements ReplyCommentService {
    @Resource
    private ReplyCommentRepository replyCommentRepository;

    @Resource
    private CommentRepository commentRepository;

    @Resource
    private DynamicRepository dynamicRepository;

    @Override
    public ResponseResult insertReplyComment(ReplyComment replyComment) {
        //添加评论
        replyCommentRepository.save(replyComment);
        //更具评论的找到对应动态
        Dynamic dynamic = dynamicRepository.findDynamicByPkDynamicId(commentRepository.findDynamicIdByPkCommentId(replyComment.getCommentId()));
        //更新动态的评论数量
        dynamic.setComments(dynamic.getComments() + 1);
        dynamicRepository.saveAndFlush(dynamic);
        return ResponseResult.success("添加评论的评论成功");

    }

    @Override
    public ResponseResult deleteReplyComment(Long id) {
        replyCommentRepository.deleteById(id);
        return ResponseResult.success("删除评论的评论成功");
    }
}
