package com.niit.soft.client.api.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class JobMapperTest {

    @Resource
    private JobMapper jobMapper;
    @Test
    void findJob() {

        System.out.println(jobMapper.findJob(1L));

    }

    @Test
    void jobList() {
        jobMapper.jobList("max").forEach(System.out::println);
    }


    @Test
    void jobListByType() {
        jobMapper.jobListByType(3L).forEach(System.out::println);
    }
}