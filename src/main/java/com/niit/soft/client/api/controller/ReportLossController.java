package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.service.ReportLossService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ReportLossController
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/1
 **/
@Slf4j
@RestController
@Api(value = "ReportLossController",tags = {"挂失接口"})
public class ReportLossController {
    @Resource
    private ReportLossService reportLossService;
    /**
     * 分页查询所有消息
     * @param pageDto
     * @return
     */
    @PostMapping("/loss/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return reportLossService.findAllByPage(pageDto);
    }

}