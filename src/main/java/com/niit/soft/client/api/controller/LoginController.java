package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.domain.dto.LoginDto;
import com.niit.soft.client.api.domain.model.UserAccount;
import com.niit.soft.client.api.service.LoginDtoService;
import com.niit.soft.client.api.service.SendSmsService;
import com.niit.soft.client.api.service.UserAccountService;
import com.niit.soft.client.api.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/24 10:27
 * @Version 1.0
 **/
@Slf4j
@RestController("/user/")
public class LoginController {
    @Resource
    private LoginDtoService loginDtoService;
    @Resource
    private UserAccountService userAccountService;
    @Autowired
    private SendSmsService sendSmsService;
    @PostMapping("login")
    public ResponseResult login(@RequestBody LoginDto loginDto) throws UnsupportedEncodingException {
        log.info("访问login接口");
        log.info("loginDto{}", loginDto);
        //如果查到数据，返回用户数据
        Long id = loginDtoService.getIdByInfo(loginDto.getUserAccount(), loginDto.getPassword());
        if (id != 0) {
            log.info("登录成功");
            log.info(userAccountService.findUserAccountById(id).toString());
            Map map = new HashedMap();
            map.put("UserAccount", userAccountService.findUserAccountById(id));
                map.put("token", JwtUtil.sign(loginDto.getUserAccount(), loginDto.getPassword()));
            return ResponseResult.success(map);
        }
        return ResponseResult.failure(ResultCode.DATA_IS_WRONG);
    }



    @PostMapping("code/login")
    public ResponseResult loginByPhone(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("verifyCode") String verifyCode) throws UnsupportedEncodingException {
        log.info("访问code/login接口");
        //如果查到数据，返回用户数据
        if (sendSmsService.verify(phoneNumber, verifyCode)) {
            log.info("登录成功");
            UserAccount userAccount = userAccountService.findUserAccountByPhoneNumber(phoneNumber);
            log.info(userAccount.toString());
            Map map = new HashedMap();
            map.put("UserAccount",userAccount);
            map.put("token", JwtUtil.sign(userAccount.getUserAccount(), userAccount.getPassword()));
            return ResponseResult.success(map);
        }
        return ResponseResult.failure(ResultCode.DATA_IS_WRONG);
    }


    @PutMapping("user/password")
    public ResponseResult changePassword(@RequestParam("userAccount") String userAccount, @RequestParam("password") String password) throws UnsupportedEncodingException {
        log.info("访问user/password接口");
        //如果查到数据，返回用户数据
        return ResponseResult.success(userAccountService.updatePasswordByUserAccount(userAccount, password));
    }


}
