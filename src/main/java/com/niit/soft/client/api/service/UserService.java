package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.User;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/24 9:47
 * @Version 1.0
 **/
public interface UserService {
    User findByUserName(String username);
}
