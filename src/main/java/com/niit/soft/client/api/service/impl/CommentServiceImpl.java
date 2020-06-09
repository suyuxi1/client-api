package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.Comment;
import com.niit.soft.client.api.domain.model.Dynamic;
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
    public ResponseResult insertComment(Comment comment) {
        commentRepository.save(comment);
        List<Comment> commentList = commentRepository.findCommentByDynamicId(comment.getDynamicId());
        Dynamic dynamic = dynamicRepository.findDynamicByPkDynamicId(comment.getDynamicId());
        dynamic.setComments(commentList.size());
        dynamicRepository.saveAndFlush(dynamic);
        return ResponseResult.success("添加成功");
    }

    @Override
    public ResponseResult deleteComment(Long commentId) {

        replyCommentRepository.deleteByCommentId(commentId);
        commentRepository.deleteById(commentId);
        return ResponseResult.success("删除成功");
    }

}
