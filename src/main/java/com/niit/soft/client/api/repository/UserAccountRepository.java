package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysUserAccountRepository
 * @Description TODO
 * @date 2020-05-26 9:55
 **/
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    UserAccount findSysUserAccountByPkUserAccountId(String id);


    /**
     * 根据id 查询账户信息
     *
     * @param id
     * @return
     */
    UserAccount findUserAccountByPkUserAccountIdEquals(Long id);


    /**
     * 根据手机号查询用户
     *
     * @param PhoneNumber
     * @return
     */
    UserAccount findUserAccountByPhoneNumberEquals(String PhoneNumber);

    @Transactional
    @Modifying
    @Query(value = "update user_account as u set u.password = ?2 where u.job_number=?1 or u.user_account=?1", nativeQuery = true)
    int updatePasswordByUserAccount(String userAccount, String password);
}
