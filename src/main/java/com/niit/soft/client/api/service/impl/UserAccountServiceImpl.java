
package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.domain.model.UserAccount;
import com.niit.soft.client.api.repository.UserAccountRepository;
import com.niit.soft.client.api.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysUserAccountServiceImpl
 * @Description TODO
 * @date 2020-05-26 10:00
 **/
@Service
@Slf4j
public class UserAccountServiceImpl implements UserAccountService {
    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public ResponseResult updateUserInfo(UserAccount sysUserAccount) {
        UserAccount updateSysUserAccount = userAccountRepository.findSysUserAccountByPkUserAccountId(sysUserAccount.getPkUserAccountId());
        //判断帐号是否被禁用
        if (updateSysUserAccount.getStatus()) {
            updateSysUserAccount.setAvatar(sysUserAccount.getAvatar());
            updateSysUserAccount.setNickname(sysUserAccount.getNickname());
            updateSysUserAccount.setGender(sysUserAccount.getGender());
            userAccountRepository.saveAndFlush(updateSysUserAccount);
            return ResponseResult.success(updateSysUserAccount);
        }
        return ResponseResult.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
    }

    @Override
    public UserAccount findUserAccountById(Long id) {
        return userAccountRepository.findUserAccountByPkUserAccountIdEquals(id);
    }
}
