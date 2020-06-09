package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CommentRepositoryTest {

    @Resource
    private CommentRepository commentRepository;

    @Test
    void findCommentByIsDeletedAndDynamicId() {
        List<Comment> commentList = commentRepository.findCommentByIsDeletedAndDynamicId(false,1L);
        System.out.println(commentList.size());
    }
}