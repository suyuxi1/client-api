package com.niit.soft.client.api.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyMapperTest {

    @Resource
    private CompanyMapper companyMapper;

    @Test
    void findDetails() {
        System.out.println(companyMapper.findDetails(1L));
    }
}