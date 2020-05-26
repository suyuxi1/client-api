package com.niit.soft.client.api.service;

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
        infoManageService.getAllInfo().forEach(System.out::println);
    }

    @Test
    void getIsTopInfo() {
        infoManageService.getIsTopInfo().forEach(System.out::println);
    }
}