package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.dto.SingleFieldDto;
import com.niit.soft.client.api.domain.model.AddressBook;
import com.niit.soft.client.api.service.AddressBookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "address_book")
public class AddressBookController {
    @Resource
    private AddressBookService addressBookService;

    @PostMapping(value = "/list/userId")
    public List<AddressBook> getAddressByUserId(@RequestBody PageDto pageDto) {
        return addressBookService.getAddressBookByUserId(pageDto.getField().toString());
    }

    @PostMapping
    public ResponseResult insertAddressBook(@RequestBody AddressBook addressBook) {
        addressBookService.insertAddressBook(addressBook);
        return ResponseResult.success();
    }


    @PutMapping(value = "/id")
    @ControllerWebLog(name = "updateAddressBook", isSaved = true)
    @ApiOperation(value = "修改通讯录好友信息", notes = "")
    public ResponseResult updateAddressBook(@RequestBody AddressBook addressBook) {
        addressBookService.updateAddressBookById(addressBook);
        return ResponseResult.success();
    }

    @DeleteMapping(value = "/deletion/id")
    @ControllerWebLog(name = "deleteAddressBookById", isSaved = true)
    @ApiOperation(value = "根据id删除通讯录好友信息", notes = "")
    public ResponseResult deleteAddressBookById(@RequestBody SingleFieldDto singleFieldDto) {
        addressBookService.deleteAddressBookById(Integer.parseInt(String.valueOf(singleFieldDto.getField())));
        return ResponseResult.success();
    }
}
