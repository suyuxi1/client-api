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

    /**
     * 根据手机号获取用户对象
     *
     * @param phoneNumber
     * @return
     */
    UserAccount findUserAccountByPhoneNumber(String phoneNumber);

    /**
     * 根据userAccount或job_number修改密码
     * @param userAccount
     * @param password
     * @return
     */
    int updatePasswordByUserAccount(String userAccount, String password);

}
