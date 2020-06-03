package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class InfoManageServiceTest {

    @Resource
    private InfoManageService infoManageService;
    @Test
    void getAllInfo() {
//        log.info(String.valueOf(infoManageService.getAll().size()));
        ResponseResult result = infoManageService.getAllInfo();
        System.out.println(result);
    }

    @Test
    void getIsTopInfo() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(2)
                .build();
        ResponseResult result = infoManageService.getIsTopInfo(pageDto);
        System.out.println(result);

    }

    @Test
    void findAllInfoByPage() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(2)
                .build();
        ResponseResult result = infoManageService.findAllInfoByPage(pageDto);
        System.out.println(result);
    }
}