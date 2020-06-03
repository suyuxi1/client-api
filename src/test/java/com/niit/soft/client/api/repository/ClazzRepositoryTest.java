package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Clazz;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ClazzRepositoryTest {

    @Resource
    private ClazzRepository clazzRepository;
    @Test
    void findClazzByPkClazzId() {
        Clazz clazz = clazzRepository.findClazzByPkClazzId(1L);
        System.out.println(clazz);
    }

    @Test
    void findByPkClazzId() {
        String name = clazzRepository.findClazzById((long)1);
        System.out.println(name);
    }
}