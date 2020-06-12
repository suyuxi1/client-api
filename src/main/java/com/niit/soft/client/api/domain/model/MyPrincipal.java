package com.niit.soft.client.api.domain.model;

import java.security.Principal;

/**
 * @ClassName MyPrincipal
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/6/10 3:35 下午
 * @Version 1.0
 **/
public class MyPrincipal implements Principal {

    private String loginName;

    public MyPrincipal(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String getName() {
        return loginName;
    }
}
