package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.UserAccount;
import com.niit.soft.client.api.service.UserAccountService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysUserAccountController
 * @Description TODO
 * @date 2020-05-26 11:08
 **/
@RestController
@RequestMapping("/user")
public class UserAccountController {
    @Resource
    private UserAccountService userAccountService;

    @PutMapping("/update/info")
    ResponseResult updateInfo(@RequestBody UserAccount userAccount){
        return userAccountService.updateUserInfo(userAccount);
    }

}
