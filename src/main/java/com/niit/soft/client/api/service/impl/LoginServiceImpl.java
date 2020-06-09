package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.repository.UserAccountRepository;
import com.niit.soft.client.api.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 8:34
 * @Version 1.0
 **/
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public Long findIdByLoginDto(String userAccount, String password) {
        log.info(userAccount + "*****" + password);
        log.info("查询id{}", userAccountRepository.findIdByLoginDto(userAccount, password));
        return userAccountRepository.findIdByLoginDto(userAccount, password);
    }
}
