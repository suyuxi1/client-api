package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.dao.SysUserRepository;
import com.niit.soft.client.api.domain.dto.LoginDto;
import com.niit.soft.client.api.service.LoginDtoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 8:34
 * @Version 1.0
 **/
@Service
public class LoginDtoImpl implements LoginDtoService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Override
    public boolean isLogin(LoginDto loginDto) {

        sysUserRepository.findOne();
        return false;
    }

}
