package com.niit.soft.client.api.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/13
 */
@SpringBootTest
@Slf4j
class UserAccountRepositoryTest {
    @Resource
    private UserAccountRepository userAccountRepository;

    @Test
    void findUserByJobNumber() {
        System.out.println(userAccountRepository.findUserByJobNumber("1802343124"));
    }

}