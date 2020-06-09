package com.niit.soft.client.api.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niit.soft.client.api.domain.model.Examination;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/8
 * @Version 1.0
 */
@SpringBootTest
class ExaminationMapperTest {
    @Resource
    private ExaminationMapper examinationMapper;

    @Test
    public void test() {
        QueryWrapper<Examination> wrapper = new QueryWrapper<>();
        wrapper.eq("pk_examination_id", 1);
        System.out.println(examinationMapper.selectOne(wrapper));
    }
}