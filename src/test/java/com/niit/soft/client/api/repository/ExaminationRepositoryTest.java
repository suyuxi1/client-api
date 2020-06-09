package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExaminationRepositoryTest {

    @Resource
    private ExaminationRepository examinationRepository;

    @Test
    void selectAll() {
//        examinationRepository.selectAll("1914866205").forEach(System.out::println);
        System.out.println(examinationRepository.selectAll("1914866205"));
    }

    @Test
    void testSelectAll() {
    }
}