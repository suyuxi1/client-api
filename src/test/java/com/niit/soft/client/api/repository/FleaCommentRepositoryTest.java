package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaCollection;
import com.niit.soft.client.api.domain.model.FleaComment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FleaCommentRepositoryTest {

    @Resource
    private FleaCommentRepository fleaCommentRepository;

    @Test
    void findAll(){
//        System.out.println(fleaCommentRepository.findAll());
        List<FleaComment> fleaComments = fleaCommentRepository.selectAll();
        fleaComments.forEach(System.out::println);
    }

}