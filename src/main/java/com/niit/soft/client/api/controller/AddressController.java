package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.AddressBook;
import com.niit.soft.client.api.service.AddressBookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "addressBook")
public class AddressController {
    @Resource
    private AddressBookService addressBookService;

    @PostMapping(value = "/list/userId")
    public List<AddressBook> getAddressByUserId(@RequestBody PageDto pageDto) {
        return addressBookService.getAddressBookByUserId(pageDto.getField().toString());
    }
}
