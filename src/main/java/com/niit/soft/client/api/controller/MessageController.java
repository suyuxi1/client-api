package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName MessageController
 * @Description TODO
 * @date 2020-05-26 16:03
 **/
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @PostMapping("/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return messageService.findAllByPage(pageDto);
    }

}
