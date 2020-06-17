package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.LoginAccountIncreased;
import com.niit.soft.client.api.domain.model.LoginAccount;
import com.niit.soft.client.api.service.LoginAccountService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName LoginAccountController.java
 * @Description TODO
 * @createTime 2020年06月17日 22:45:00
 */
@Slf4j
@RestController
@Api(tags = "第三方账号管理")
public class LoginAccountController {
    @Resource
    private LoginAccountService loginAccountService;

    @PostMapping("/LoginAccount/increased")
    ResponseResult increasedLoginAccount(@RequestBody LoginAccountIncreased loginAccountIncreased) {
        return loginAccountService.increasedLoginAccount(loginAccountIncreased);
    }
}
