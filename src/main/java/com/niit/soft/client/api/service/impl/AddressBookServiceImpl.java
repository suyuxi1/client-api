package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.domain.model.AddressBook;
import com.niit.soft.client.api.repository.AddressBookRepository;
import com.niit.soft.client.api.service.AddressBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@Service
public class AddressBookServiceImpl implements AddressBookService {
    @Resource
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBook> getAddressBookByUserId(String userId) {
        return addressBookRepository.getAddressBookByUserId(userId);
    }
}
