package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.domain.model.AddressBook;
import com.niit.soft.client.api.domain.model.SysUser;
import com.niit.soft.client.api.domain.model.UserAccount;
import com.niit.soft.client.api.repository.AddressBookRepository;
import com.niit.soft.client.api.repository.SysUserRepository;
import com.niit.soft.client.api.repository.UserAccountRepository;
import com.niit.soft.client.api.service.AddressBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AddressBookServiceImpl implements AddressBookService {
    @Resource
    private AddressBookRepository addressBookRepository;
    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public List<AddressBook> getAddressBookByUserId(String userId) {
        return addressBookRepository.getAddressBookByUserId(userId);
    }

    @Override
    public void insertAddressBook(AddressBook addressBook) {
        UserAccount user = userAccountRepository.findSysUserAccountByPkUserAccountId(addressBook.getUserId());
        System.out.println(user);
        addressBook.setAvatar(user.getAvatar());
        addressBook.setGmtCreate(Timestamp.valueOf(LocalDateTime.now()));
        addressBook.setGmtModified(Timestamp.valueOf(LocalDateTime.now()));
        addressBook.setIsDeleted(false);
        addressBook.setRemark(user.getNickname());
        addressBookRepository.save(addressBook);
    }

    @Override
    public void deleteAddressBookById(long id) {
        addressBookRepository.deleteById(id);
    }

    @Override
    public void updateAddressBookById(AddressBook addressBook) {
        addressBookRepository.updateAddressBookById(addressBook);
    }
}
