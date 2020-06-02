package com.niit.soft.client.api.service;


import com.niit.soft.client.api.domain.model.AddressBook;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
public interface AddressBookService {

    /**
     * 根据用户id获取通讯录信息
     * @param userId
     * @return
     */
    List<AddressBook> getAddressBookByUserId(String userId);
}
