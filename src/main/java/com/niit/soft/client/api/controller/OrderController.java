package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 查询清单明细
     * @param jobNumber
     * @return
     */
      @GetMapping("/card/consume")
    ResponseResult findAllByJobNumber(@RequestParam("job_number") String  jobNumber){
          return orderService.findALLByJobNumer(jobNumber);
      }
}