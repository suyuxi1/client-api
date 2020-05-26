package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.model.UserAccount;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 10:22
 * @Version 1.0
 **/
public interface UserAccountService {
    /**
     * 根据主键查询用户信息
     * @param id
     * @return
     */
    UserAccount findUserAccountById(Long id);
}
