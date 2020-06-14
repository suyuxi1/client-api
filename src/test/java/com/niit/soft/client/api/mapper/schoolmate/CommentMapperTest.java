package com.niit.soft.client.api.mapper.schoolmate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CommentMapperTest {
    @Resource
    private CommentMapper commentMapper;

    @Test
    void findCommentVoById() {
        System.out.println(commentMapper.findCommentVoById("1271346795213361152"));
    }
}