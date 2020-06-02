package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

    /**
     * 根据phoneNumber查询通讯录
     * @param userId
     * @return
     */
    @Query("SELECT u FROM AddressBook u " +
            "WHERE u.userId=?1 ")
    List<AddressBook> getAddressBookByUserId(String userId);
}
