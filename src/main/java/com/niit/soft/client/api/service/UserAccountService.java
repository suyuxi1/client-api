
package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.UserAccount;

/**
 * @author Tao
 */
public interface UserAccountService {
    /**
     * 修改
     * @param sysUserAccount
     * @return
     */
    ResponseResult updateUserInfo(UserAccount sysUserAccount);

    /**
     * 根据主键查询用户信息
     * @param id
     * @return
     */
    UserAccount findUserAccountById(Long id);

    /**
     * 根据用户唯一信息获取用户对象
     *
     * @param info
     * @return
     */
    UserAccount findUserAccountByInfo(String info);

    /**
     * 根据userAccount或job_number或phoneNumber修改密码
     * @param userAccount
     * @param password
     * @return
     */
    int updatePasswordByUserAccount(String userAccount, String password);

}
