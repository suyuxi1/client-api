package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.domain.model.User;
import com.niit.soft.client.api.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/24 9:48
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findByUserName(String username) {
        if ("ntt".equals(username)) {
            return User.builder().name("涛涛").username("ntt").password("123").build();
        }
        return null;
    }
}
