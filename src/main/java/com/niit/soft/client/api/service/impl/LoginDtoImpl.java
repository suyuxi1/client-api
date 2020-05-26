package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.repository.SysUserRepository;
import com.niit.soft.client.api.service.LoginDtoService;
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
public class LoginDtoImpl implements LoginDtoService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Override
    public Long getIdByInfo(String userAccount, String password) {
        log.info(userAccount + "*****" + password);
        log.info("查询id{}", sysUserRepository.findIdByLoginDto(userAccount, password));
        return sysUserRepository.findIdByLoginDto(userAccount, password);
    }
}
