package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.model.AddressBook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/3
 * @Version 1.0
 */
@SpringBootTest
class AddressBookServiceTest {
    @Resource
    private AddressBookService addressBookService;

    @Test
    void getAddressBookByUserId() {
        System.out.println(addressBookService.getAddressBookByUserId("1"));
    }

    @Test
    void insertAddressBook() {
        AddressBook addressBook = AddressBook.builder()
                .phoneNumber("18851855106")
                .userId("2")
                .build();
        addressBookService.insertAddressBook(addressBook);
    }

    @Test
    void deleteAddressBookById() {
        addressBookService.deleteAddressBookById(2);
    }

    @Test
    void updateAddressBookById() {
    }
}