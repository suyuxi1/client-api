package com.niit.soft.client.api.mapper.schoolmate;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
class DynamicMapperTest {
    @Resource
    private DynamicMapper dynamicMapper;

    @Test
    void findDynamicVoById() {
        System.out.println(dynamicMapper.findDynamicVoById("1271346795213361152"));
    }
}