package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName CardController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/26
 **/
@Slf4j
@RestController
public class CardController {
    @Resource
    private CardService service;
    /**
     * 查询所有消息
     * @param pageDto
     * @return
     */
    @ApiOperation(value = "查询所有",notes = "请求参数为当前页和页面条数")
    @PostMapping("/card/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return service.findAllByPage(pageDto);
    }

    /**
     * 查询余额
     * @param jobNumber
     * @return
     */
    @GetMapping("/card/balance")
    ResponseResult findcardBalanceByJobNumber(@RequestParam("job_number") String jobNumber){
        return  service.selectCardBalance(jobNumber);
    }

    /**
     * 校园卡充值
     * @param cardNumber
     * @param money
     * @return
     */
    @ApiOperation(value = "校园卡充值",notes = "请求参数为校园卡号码，充值金额")
    @PutMapping("/card/deposit")
    ResponseResult insertCardBalance(@RequestParam("card_number") String cardNumber,
                                     @RequestParam("money") double money){
        return service.insertCardBalance(cardNumber,money);
    }
    /**
     * 电费充值0
     * @param id
     * @param money
     * @return
     */
    @ApiOperation(value = "电费充值",notes = "请求参数为房间id，充值金额")
    @PutMapping("/electricity/deposit")
    ResponseResult insertEleBalance(@RequestParam("id") Long id,
                                     @RequestParam("money") double money){
        return service.insertelectricityBalance(id,money);
    }

}