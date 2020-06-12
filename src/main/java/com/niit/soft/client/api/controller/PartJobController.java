package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.service.PartJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author su
 * @className JobController
 * @Description TODO
 * @Date 2020/6/9
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/partJob")
@Api(tags = "校园聘的接口")
public class PartJobController {

    @Resource
    private PartJobService jobService;

    @PostMapping("/byPay")
//    @ControllerWebLog(name = "find")
    @ApiOperation(value = "根据给定条件查找兼职降序排列", notes = "请求参数为传递分页参数")
    ResponseResult findPartJob(@RequestBody PageDto pageDto){
        return ResponseResult.success(jobService.findAllByPage(pageDto));
    }



}
