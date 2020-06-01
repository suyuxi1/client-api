package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.ScheduleDto;
import com.niit.soft.client.api.service.SysCourseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysCourseServiceImplTest {

    @Resource
    private SysCourseService sysCourseService;

    @Test
    void findWeekCourseTableByScheduleDto() {
        ScheduleDto scheduleDto = ScheduleDto.builder()
                .clazzId((long)1)
                .semesterId((long)1)
                .week(1)
                .build();
        ResponseResult result = sysCourseService.findWeekCourseTableByScheduleDto(scheduleDto);
        System.out.println(result);
    }
}