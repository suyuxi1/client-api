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
@Api(tags = "一卡通接口")
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
     * 查询校园卡余额
     * @param jobNumber
     * @return
     */
    @ApiOperation(value = "查询校园卡余额",notes = "请求参数为学号")
    @PostMapping("/card/balance")
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
     * 电费充值
     * @param name
     * @param money
     * @return
     */
    @ApiOperation(value = "电费充值",notes = "请求参数为房间名字，充值金额")
    @PutMapping("/electricity/deposit")
    ResponseResult insertEleBalance(@RequestParam("name") String name,
                                    @RequestParam("money") double money){
        return service.insertelectricityBalance(name,money);
    }
    /**
     * 网费充值
     * @param jobNumber
     * @param money
     * @return
     */
    @ApiOperation(value = "网费充值",notes = "请求参数为学号，充值金额")
    @PutMapping("/net/deposit")
    ResponseResult insertBalance(@RequestParam("job_number") String jobNumber,
                                    @RequestParam("money") double money){
        return service.insertBalance(jobNumber,money);
    }
    /**
     * 一卡通激活
     * @param pkCardId
     * @param Status
     * @return
     */
    @PostMapping("card/statusChange")
    @ApiOperation(value = "一卡通激活",notes = "请求参数为id，状态")
    ResponseResult updateStatus(@RequestParam("pk_card_id")Long pkCardId,
                                @RequestParam("status") Boolean Status){
        return service.updateStatus(pkCardId, Status);
    }
}