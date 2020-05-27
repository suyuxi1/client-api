package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.repository.UserAccountRepository;
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
        return userAccountRepository.findUserAccountByInfo(id.toString());
    }

    @Override
    public UserAccount findUserAccountByInfo(String info) {
        return userAccountRepository.findUserAccountByInfo(info);
    }

    @Override
    public int updatePasswordByUserAccount(String userAccount, String password) {
        return userAccountRepository.updatePasswordByUserAccount(userAccount, password);
    }

    @Override
    public ResponseResult updateUserInfo(UserAccount sysUserAccount) {
        UserAccount updateSysUserAccount = userAccountRepository.findUserAccountByInfo(sysUserAccount.getPkUserAccountId().toString());
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

}
