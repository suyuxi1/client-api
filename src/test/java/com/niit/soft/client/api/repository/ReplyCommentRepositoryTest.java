package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReplyCommentRepositoryTest {
    @Resource
    private ReplyCommentRepository replyCommentRepository;

    @Test
    void deleteByPkReplyCommentId() {
//        replyCommentRepository.deleteByCommentId(2L);
        System.out.println(replyCommentRepository.selectAllCommentId(1L));
    }
    @Test
    void update(){
        List<Long> ids = new ArrayList<>();
        ids.add((long)4);
        ids.add((long)8);
        int a = replyCommentRepository.updateIsDelete(ids);
        System.out.println(a);
    }

}