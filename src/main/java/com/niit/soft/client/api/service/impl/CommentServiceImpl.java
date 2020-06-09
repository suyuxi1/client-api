package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.CommentDto;
import com.niit.soft.client.api.domain.model.Comment;
import com.niit.soft.client.api.domain.model.Dynamic;
import com.niit.soft.client.api.domain.model.ReplyComment;
import com.niit.soft.client.api.repository.CommentRepository;
import com.niit.soft.client.api.repository.DynamicRepository;
import com.niit.soft.client.api.repository.ReplyCommentRepository;
import com.niit.soft.client.api.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName CommentServiceImpl
 * @Description 评论
 * @Date 2020/6/8  16:21
 * @Version 1.0
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentRepository commentRepository;

    @Resource
    private DynamicRepository dynamicRepository;

    @Resource
    private ReplyCommentRepository replyCommentRepository;

    @Override
    public ResponseResult insertComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setIsDeleted(false);
        comment.setContent(commentDto.getContent());
        comment.setDynamicId(commentDto.getDynamicId());
        comment.setUserId(commentDto.getUserId());
        commentRepository.save(comment);
        List<Comment> commentList = commentRepository.findCommentByDynamicId(commentDto.getDynamicId());
        Dynamic dynamic = dynamicRepository.findDynamicByPkDynamicId(comment.getDynamicId());
        dynamic.setComments(commentList.size());
        dynamicRepository.saveAndFlush(dynamic);
        return ResponseResult.success("添加成功");
    }

    @Override
    public ResponseResult deleteComment(Long commentId) {
        Comment comment = commentRepository.findCommentByPkCommentId(commentId);
        comment.setIsDeleted(true);
        commentRepository.saveAndFlush(comment);
        List<ReplyComment> replyCommentList = replyCommentRepository.findByCommentId(commentId);
        replyCommentList.forEach(replyComment -> {
            ReplyComment replyComment1 = replyCommentRepository.findReplyCommentByPkReplyCommentId(replyComment.getPkReplyCommentId());
            replyComment1.setIsDeleted(true);
            replyCommentRepository.saveAndFlush(replyComment1);
        });
//        List<Long> ids = replyCommentRepository.selectAllCommentId(commentId);
//        replyCommentRepository.updateIsDelete(ids);
        return ResponseResult.success("删除成功");
    }

}
