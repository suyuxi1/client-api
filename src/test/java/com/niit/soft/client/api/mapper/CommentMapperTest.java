package com.niit.soft.client.api.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CommentMapperTest {
    @Resource
    private CommentMapper commentMapper;

    @Test
    void findCommentVoById() {
        System.out.println(commentMapper.findCommentVoById(1L));
    }
}