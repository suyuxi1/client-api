package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAccountRepositoryTest {

    @Resource
    private UserAccountRepository userAccountRepository;

    @Test
    void findUserNameByUserJobNumber() {
        String userName = userAccountRepository.findUserNameByUserJobNumber("1802343210");
        System.out.println(userName);
    }
}