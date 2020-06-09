package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CommentRepositoryTest {

    @Resource
    private CommentRepository commentRepository;
    @Test
    void findCommentByDynamicId() {
//        commentRepository.deleteById(3L);
//        System.out.println(commentRepository.findCommentByDynamicId(1L));

    }

}