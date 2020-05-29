package com.niit.soft.client.api.service;

import com.niit.soft.client.api.repository.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserAccountServiceTest {

    @Resource
    private UserAccountService userAccountService;
    @Resource
    private UserAccountRepository userAccountRepository;
    @Test
    void findUserAccountById() {
        System.out.println(userAccountService.findUserAccountById(1L));
    }

    @Test
    void updatePasswordByUserAccount(){
        System.out.println(userAccountService.findUserAccountById(1L));
        userAccountRepository.updatePasswordByUserAccount("1914866205", "1234");
        System.out.println(userAccountService.findUserAccountById(1L));
    }



}