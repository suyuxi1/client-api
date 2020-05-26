package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MessageServiceTest {
    @Resource
    private MessageService messageService;

    @Test
    void findAllByPage() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(4)
                .build();
        ResponseResult result = messageService.findAllByPage(pageDto);
        System.out.println(result);
    }
}