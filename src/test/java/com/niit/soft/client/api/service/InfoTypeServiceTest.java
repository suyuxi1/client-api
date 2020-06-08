package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InfoTypeServiceTest {

    @Resource
    private InfoTypeService infoTypeService;

    @Test
    void findInfoByTypeId() {
        PageDto pageDto = PageDto.builder()
                .field("1")
                .currentPage(0)
                .pageSize(2)
                .build();
        ResponseResult result = infoTypeService.findInfoByTypeId(pageDto);
        System.out.println(result);
    }
}