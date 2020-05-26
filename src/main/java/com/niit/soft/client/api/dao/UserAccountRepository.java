package com.niit.soft.client.api.dao;

import com.niit.soft.client.api.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 10:20
 * @Version 1.0
 **/
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    /**
     * 根据id 查询账户信息
     * @param id
     * @return
     */
    UserAccount findUserAccountByPkUserAccountIdEquals(Long id);
}
