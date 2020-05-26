package com.niit.soft.client.api.dao;

import com.niit.soft.client.api.domain.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 8:23
 * @Version 1.0
 **/

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    //根据dto查询用户
    @Query(value = "select s.pk_user_account_id from user_account s where s.job_number=?1 or s.user_account=?1 and s.password=?2",nativeQuery = true)
    Long findIdByLoginDto(String userAccount,String password);

}
