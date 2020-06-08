package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.ThumbDto;
import com.niit.soft.client.api.service.ThumbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Yujie_Zhao
 * @ClassName SchoolmateController
 * @Description 校友圈模块Controller
 * @Date 2020/6/8  15:27
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/Schoolmate")
@Api(value = "SchoolmateController",tags = {"校友圈接口"})
public class SchoolmateController {
    @Resource
    private ThumbService thumbService;

    /**
     * 添加校友圈点赞
     * @return
     */
    @ApiOperation(value = "添加校友圈点赞",notes = "")
    @PostMapping(value = "/Thumb/insert")
    public ResponseResult insertThumb(@RequestBody ThumbDto thumbDto){
        return thumbService.insertThumb(thumbDto);
    }

    /**
     * 删除校友圈点赞
     * @param thumbDto
     * @return
     */
    @ApiOperation(value = "删除校友圈点赞",notes = "")
    @PostMapping(value = "/Thumb/deletion")
    public ResponseResult deleteThumb(@RequestBody ThumbDto thumbDto){
        return thumbService.deleteThumb(thumbDto);
    }

}
