package com.niit.soft.client.api.dao;

import com.niit.soft.client.api.domain.dto.LoginDto;
import com.niit.soft.client.api.domain.model.SysUser;
import com.niit.soft.client.api.domain.model.SysUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/5/26 8:23
 * @Version 1.0
 **/

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    /**
     * 根据班级id查询所有班级学生
     *
     * @param clazzId
     * @return
     */
    @Query(value = "select student_id,student_name,birthday,hometown from student where clazz_id=?1", nativeQuery = true)
    List<Student> findStudentsByClazzId(Integer clazzId);

    //根据dto查询用户
    @Query(value = "select pk_user_account_id from sys_user_account where job_number=#{loginDto.userAccount} or user_account=#{loginDto.userAccount} and password")
    Long findSysUserByLoginDto(LoginDto loginDto);

}
