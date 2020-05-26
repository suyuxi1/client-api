package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserAccountServiceTest {

    @Resource
    private UserAccountService sysUserAccountService;

    @Test
    void updateUserInfo() {
        UserAccount sysUserAccount = UserAccount.builder()
                .pkUserAccountId(Long.valueOf(1))
                .avatar("cs.jpg")
                .nickname("Tao~")
                .gender("男")
                .build();
        ResponseResult result = sysUserAccountService.updateUserInfo(sysUserAccount);
        System.out.println(result);
    }
}