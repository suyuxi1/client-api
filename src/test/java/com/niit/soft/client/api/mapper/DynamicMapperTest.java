package com.niit.soft.client.api.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class DynamicMapperTest {
    @Resource
    private DynamicMapper dynamicMapper;

    @Test
    void findDynamicVoById() {
        System.out.println(dynamicMapper.findDynamicVoById(Long.valueOf("1271347661651709952")));
    }
}