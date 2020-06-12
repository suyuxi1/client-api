package com.niit.soft.client.api.mapper;

import com.niit.soft.client.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobMapperTest {

    @Resource
    private JobMapper jobMapper;
    @Test
    void findJob() {
        String field = "max";
        jobMapper.findJob(field).forEach(System.out::println);
    }
}