package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserAccountRepositoryTest {
    @Resource
    private UserAccountRepository sysUserAccountRepository;

    /**
     * 测试根据id查询账户数据信息
     */
    @Test
    void findSysUserAccountByPkUserAccountId() {
//        UserAccount sysUserAccount = sysUserAccountRepository.findSysUserAccountByPkUserAccountId(Long.valueOf(1));
//        System.out.println(sysUserAccount);
        System.out.println(".......................");
        System.out.println(sysUserAccountRepository.findUserAccountByInfo("1"));
        System.out.println(".......................");
        System.out.println(".......................");
        System.out.println(sysUserAccountRepository.findUserAccountByInfo("1914866205"));
        System.out.println(".......................");
        System.out.println(".......................");
        System.out.println(sysUserAccountRepository.findUserAccountByInfo("1802343210"));
        System.out.println(".......................");
        System.out.println(".......................");
        System.out.println(sysUserAccountRepository.findUserAccountByInfo("18851855106"));
        System.out.println(".......................");


    }

}