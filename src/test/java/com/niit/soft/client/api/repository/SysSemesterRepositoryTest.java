package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.SysSemester;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysSemesterRepositoryTest {

    @Resource
    private SysSemesterRepository sysSemesterRepository;

    @Test
    void findSysSemesterByName() {
        SysSemester sysSemester = sysSemesterRepository.findSysSemesterByName("2011-2012学年第一学期");
        System.out.println(sysSemester);
    }

    @Test
    void insertSysSemester() {
        List<SysSemester> sysSemesterList = new ArrayList<>();
        for (int i= 0;i<=15;i++){
            SysSemester sysSemester1 = SysSemester.builder()
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .weekCount(15)
                    .openSchoolTime(Timestamp.valueOf((2012+i)+"-02-24 08:11:18"))
                    .name((2011+i)+"-"+(2012+i)+"学年第二学期")
                    .build();
            sysSemesterList.add(sysSemester1);
            SysSemester sysSemester2 = SysSemester.builder()
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .weekCount(16)
                    .openSchoolTime(Timestamp.valueOf((2011+i)+"-09-01 08:11:18"))
                    .name((2011+i)+"-"+(2012+i)+"学年第一学期")
                    .build();
            sysSemesterList.add(sysSemester2);
        }
        sysSemesterRepository.saveAll(sysSemesterList);
    }
}