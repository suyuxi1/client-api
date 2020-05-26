package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.dao.UserAccountRepository;
import com.niit.soft.client.api.domain.model.UserAccount;
import com.niit.soft.client.api.service.UserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 10:22
 * @Version 1.0
 **/
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Resource
    private UserAccountRepository userAccountRepository;
    @Override
    public UserAccount findUserAccountById(Long id) {
        return userAccountRepository.findUserAccountByPkUserAccountIdEquals(id);
    }
}
