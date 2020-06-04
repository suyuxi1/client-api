package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.ScheduleDto;
import com.niit.soft.client.api.service.SysCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysCourseController
 * @Description TODO
 * @date 2020-06-04 9:50
 **/
@Slf4j
@RestController
@RequestMapping("/course")
@Api(value = "SysCourseController",tags = {"课程模块接口"})
public class SysCourseController {
    @Resource
    private SysCourseService sysCourseService;

    @ApiOperation(value = "根据week、学期、周几数查询课程表接口",notes = "")
    @PostMapping(value = "/schedule")
    @ControllerWebLog(name = "findWeekCourseTableByScheduleDto", isSaved = true)
    public ResponseResult findWeekCourseTableByScheduleDto(@RequestBody ScheduleDto scheduleDto){
        log.info("-----/schedule-----请求参数：" + scheduleDto+"**1**");
        return sysCourseService.findWeekCourseTableByScheduleDto(scheduleDto);
    }
}