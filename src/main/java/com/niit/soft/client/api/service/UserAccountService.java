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
}
