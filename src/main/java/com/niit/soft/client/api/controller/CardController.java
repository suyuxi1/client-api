package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.CardBalance;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.service.CardService;
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
     * 查询余额
     *
     * @param jobNumber
     * @return
     */
    @ApiOperation(value = "查询余额", notes = "请求参数为当学号")
    @GetMapping("/card/balance")
    @ControllerWebLog(name = "findcardBalanceByJobNumber", isSaved = true)
    ResponseResult findcardBalanceByJobNumber(@RequestParam("job_number") String jobNumber) {
        log.info("-----/card/balance-----请求参数：" + jobNumber+"**1**");
        return service.selectCardBalance(jobNumber);
    }

    /**
     * 校园卡充值
     *
     * @return
     */
    @ControllerWebLog(name = "insertCardBalance", isSaved = true)
    @ApiOperation(value = "校园卡充值", notes = "请求参数为校园卡号码，充值金额")
    @PutMapping("/card/deposit")
    ResponseResult insertCardBalance(@RequestBody CardBalance cardBalance) {
        log.info("-----/card/deposit-----请求参数：" + cardBalance+"**1**");
        return service.insertCardBalance(cardBalance.getCardNumber(), cardBalance.getMoney());
    }


}