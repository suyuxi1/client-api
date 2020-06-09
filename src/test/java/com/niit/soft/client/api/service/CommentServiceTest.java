package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.CommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CommentServiceTest {
    @Resource
    private CommentService commentService;

    @Test
    void insertComment() {
        CommentDto commentDto = CommentDto.builder()
                .dynamicId(1L)
                .userId(1L)
                .content("你好")
                .build();
        commentService.insertComment(commentDto);
    }

    @Test
    void deleteComment() {
        commentService.deleteComment(1L);
    }
}