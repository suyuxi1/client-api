package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 10:20
 * @Version 1.0
 **/
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
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
    @Query(value = "update user_account as u set u.password = ?2 where u.job_number=?1 or u.user_account=?1",nativeQuery = true)
    int updatePasswordByUserAccount(String userAccount, String password);
}
