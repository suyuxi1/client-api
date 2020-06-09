package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.ReplyCommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ReplyCommentServiceTest {

    @Resource
    private ReplyCommentService replyCommentService;

    @Test
    void insertReplyComment() {
        ReplyCommentDto replyComment = ReplyCommentDto.builder()
                .commentId(1L)
                .content("Hello")
                .userId(1L)
                .build();
        replyCommentService.insertReplyComment(replyComment);
    }

    @Test
    void deleteReplyComment() {
        replyCommentService.deleteReplyComment(4L);
    }
}