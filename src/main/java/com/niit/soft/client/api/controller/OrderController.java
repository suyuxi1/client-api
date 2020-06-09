package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.service.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/29
 **/
@Slf4j
@RestController
@Api(tags = "订单接口")

public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 查询清单明细
     * @param jobNumber
     * @return
     */
      @PostMapping("/card/consume")
    ResponseResult findAllByJobNumber(@RequestParam("job_number") String  jobNumber){
          return orderService.findALLByJobNumer(jobNumber);
      }
}