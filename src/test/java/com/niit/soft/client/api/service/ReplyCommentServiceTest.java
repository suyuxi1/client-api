package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.model.ReplyComment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ReplyCommentServiceTest {

    @Resource
    private ReplyCommentService replyCommentService;

    @Test
    void insertReplyComment() {
        ReplyComment replyComment = ReplyComment.builder()
                .commentId(1L)
                .isDeleted(false)
                .content("Hello")
                .userId(1L)
                .build();
        replyCommentService.insertReplyComment(replyComment);
    }

    @Test
    void deleteReplyComment() {
        replyCommentService.deleteReplyComment(2L);
    }
}