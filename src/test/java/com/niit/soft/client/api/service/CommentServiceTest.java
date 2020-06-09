package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.model.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CommentServiceTest {
    @Resource
    private CommentService commentService;

    @Test
    void insertComment() {
        Comment comment = Comment.builder()
                .dynamicId(1L)
                .userId(1L)
                .content("你好")
                .isDeleted(true)
                .build();
        commentService.insertComment(comment);
    }

    @Test
    void deleteComment() {
        commentService.deleteComment(7L);
    }
}