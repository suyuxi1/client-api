package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.ThumbDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class ThumbServiceTest {

    @Resource
    private ThumbService thumbService;
    @Test
    void insertThumb() {
        ThumbDto thumbDto = ThumbDto.builder()
                .dynamicId(4L)
                .userId(3L)
                .build();
        thumbService.insertThumb(thumbDto);
    }

    @Test
    void deleteThumb() {
        ThumbDto thumbDto = ThumbDto.builder()
                .dynamicId(1L)
                .userId(1L)
                .build();
        thumbService.deleteThumb(thumbDto);
    }
}