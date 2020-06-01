package com.niit.soft.client.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.ScheduleDto;
import com.niit.soft.client.api.domain.model.Schedule;
import com.niit.soft.client.api.repository.ClazzRepository;
import com.niit.soft.client.api.repository.ScheduleRepository;
import com.niit.soft.client.api.repository.SysCourseRepository;
import com.niit.soft.client.api.repository.SysSubjectRepository;
import com.niit.soft.client.api.service.SysCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysCourseServiceImpl
 * @Description TODO
 * @date 2020-05-30 15:54
 **/
@Service
@Slf4j
public class SysCourseServiceImpl implements SysCourseService {
    @Resource
    private SysCourseRepository sysCourseRepository;

    @Resource
    private ScheduleRepository scheduleRepository;

    @Resource
    private ClazzRepository clazzRepository;

    @Resource
    private SysSubjectRepository sysSubjectRepository;


    @Override
    public ResponseResult findWeekCourseTableByScheduleDto(ScheduleDto scheduleDto) {

        //通过clazzId、semesterId、weekId查询出符合Schedule的数据
        Schedule schedule = scheduleRepository.findScheduleByClazzIdAndSemesterIdAndWeek(
                scheduleDto.getClazzId(),scheduleDto.getSemesterId(),scheduleDto.getWeek());

        List<Map<String,Object>> scheduleLists = sysCourseRepository.selectById(schedule.getPkSchoolTimetableId());
//        System.out.println(scheduleLists);
        //查询出班级名称
        String clazzName = clazzRepository.findClazzById(schedule.getClazzId());

        //遍历list查询出单个课程的科目相关信息
        for (Map<String,Object> sch:scheduleLists){
//            SysSubject sysSubjects = sysSubjectRepository.findSysSubjectByPkSubjectId(Long.parseLong(sch.get("subject_id").toString()));
            System.out.println(JSON.toJSON(sch));

//            sch.put("sysSubjects",sysSubjects);
//            System.out.println(sysSubjects);
        }



        return ResponseResult.success(JSON.toJSON(scheduleLists));
    }
}
