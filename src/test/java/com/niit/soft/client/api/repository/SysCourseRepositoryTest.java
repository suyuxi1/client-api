package com.niit.soft.client.api.repository;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SysCourseRepositoryTest {

    @Resource
    private SysCourseRepository sysCourseRepository;


    @Test
    void selectById() {
        List<Map<String,Object>> mapList = sysCourseRepository.selectById((long)1);
//        System.out.println(mapList.get(0).get("name"));
        System.out.println(JSON.toJSON(mapList));
    }
}