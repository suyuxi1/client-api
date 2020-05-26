package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysUserAccountRepository
 * @Description TODO
 * @date 2020-05-26 9:55
 **/
public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    UserAccount findSysUserAccountByPkUserAccountId(Long id);


}
