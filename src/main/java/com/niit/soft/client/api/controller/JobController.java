package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.service.JobService;
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
 * @Date 2020/6/11
 * @Version 1.0
 **/


@Slf4j
@RestController
@RequestMapping("/job")
@Api(tags = "校园聘的接口")
public class JobController {


    @Resource
    private JobService jobService;

    @PostMapping("/list")
    @ApiOperation(value = "Job列表",  notes = "请求参数为传递分页的field属性")
    public ResponseResult findJob(@RequestBody PageDto pageDto){
        return ResponseResult.success(jobService.find(pageDto.getField().toString()));
    }

}
