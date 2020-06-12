package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.service.JobTypeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author su
 * @className JobTypeController
 * @Description TODO
 * @Date 2020/6/11
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/jobType")
@Api(tags = "校招分类")
public class JobTypeController {

    @Resource
    private JobTypeService jobTypeService;

    @PostMapping("/type")
    public ResponseResult findType(){
        return ResponseResult.success(jobTypeService.findType());
    }

}
