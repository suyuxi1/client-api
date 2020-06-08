package com.niit.soft.client.api.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.niit.soft.client.api.domain.model.Dynamic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
class DynamicMapperTest {
    @Resource
    private DynamicMapper dynamicMapper;

    @Test
    void findDynamicVoById() {
        System.out.println(dynamicMapper.findDynamicVoById(1L));
    }

    @Test
    void deleteDynamicById() {
        UpdateWrapper<Dynamic> wrapper = new UpdateWrapper<>();
        wrapper.set("is_deleted", 0);
        dynamicMapper.update(Dynamic.builder().pkDynamicId(1L)
                .comments(1).thumbs(1).content("")
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now())).build(), wrapper);
    }
}