package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.domain.dto.LoginDto;
import com.niit.soft.client.api.service.LoginDtoService;
import com.niit.soft.client.api.service.UserAccountService;
import com.niit.soft.client.api.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/index")
    public String index() {
        return "进入首页";
    }

    @GetMapping("/other")
    public String other() {
        return "进入功能页";
    }

}
