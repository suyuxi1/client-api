package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class AddressBookRepositoryTest {
    @Resource
    private  AddressBookRepository addressBookRepository;

    @Test
    void findAddressBookByPhoneNumber() {
        System.out.println(addressBookRepository.findAddressBookByPhoneNumber("14752191352"));

    }

    @Test
    void findAddressBookByRealNameLikeAndRemarkLike() {
        System.out.println(addressBookRepository.findAddressBookByRemarkContaining("孙"));
    }

    @Test
    void getAll() {
//        System.out.println(addressBookRepository.getAll());
    }
}