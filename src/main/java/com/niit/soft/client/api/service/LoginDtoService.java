package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.LoginDto;
import com.niit.soft.client.api.domain.model.SysUser;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 8:34
 * @Version 1.0
 **/
public interface LoginDtoService {
    /**
     * 登录
     * @param
     * @return 返回用户信息
     */
    Long findIdByLoginDto(String userAccount,String password);
}
