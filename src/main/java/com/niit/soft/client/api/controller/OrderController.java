package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.JobNumberDto;
import com.niit.soft.client.api.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/29
 **/
@Slf4j
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 查询清单明细
     * @param jobNumber
     * @return
     */
      @PostMapping("/card/consume")
      @ApiOperation(value = "查询清单明细",notes = "请求参数为学号")
      @ControllerWebLog(name = "findAllByJobNumber", isSaved = true)
      ResponseResult findAllByJobNumber(@RequestBody JobNumberDto jobNumber){
          return orderService.findALLByJobNumer(jobNumber.getJobNumber());
      }
}