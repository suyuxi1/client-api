package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScheduleRepositoryTest {
    @Resource
    private ScheduleRepository scheduleRepository;

    @Test
    void findScheduleByClazzIdAndSemesterIdAndWeek() {
        Schedule schedule = scheduleRepository.findScheduleByClazzIdAndSemesterIdAndWeek((long)1, (long) 1,1);
        System.out.println(schedule);
    }
}