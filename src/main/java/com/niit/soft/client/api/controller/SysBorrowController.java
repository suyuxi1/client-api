package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.JobNumberDto;
import com.niit.soft.client.api.service.SysBorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysBorrowController
 * @Description TODO
 * @date 2020-06-02 9:50
 **/
@Slf4j
@RestController
@RequestMapping("/book")
@Api(value = "SysBorrowController",tags = {"借阅图书模块接口"})
public class SysBorrowController {
    @Resource
    private SysBorrowService sysBorrowService;

    @ApiOperation(value = "查询所有借阅图片接口",notes = "")
    @PostMapping(value = "/record")
    @ControllerWebLog(name = "findAllSysSemester", isSaved = true)
    public ResponseResult findAllSysSemester(@RequestBody JobNumberDto jobNumberDto){
        log.info("-----/record-----请求参数：" + jobNumberDto+"**1**");
        return sysBorrowService.findSysBorrowsByBorrowUserNumber(jobNumberDto.getJobNumber());
    }

    @ApiOperation(value = "查询用户借阅书本量",notes = "")
    @ControllerWebLog(name = "countByBorrowUserNumber", isSaved = true)
    @PostMapping(value = "/number")
    public ResponseResult countByBorrowUserNumber(@RequestBody JobNumberDto jobNumberDto){
        log.info("-----/number-----请求参数：" + jobNumberDto+"**1**");
        return sysBorrowService.countByBooks(jobNumberDto.getJobNumber());
    }
}
