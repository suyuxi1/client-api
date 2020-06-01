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

    /**
     * 生成一些学期的数据
     */
    @Test
    void insertSysSemester() {
        List<SysSemester> sysSemesters = new ArrayList<>();
        for (int i = 1 ;i<10;i++){
            SysSemester sysSemester = SysSemester.builder()
                    .name((2010+i)+"-"+(2011+i)+"学年第二学期")
                    .weekCount(16)
                    .isDeleted(false)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
            sysSemesters.add(sysSemester);
            SysSemester sysSemester1 = SysSemester.builder()
                    .name((2010+i)+"-"+(2011+i)+"学年第一学期")
                    .weekCount(15)
                    .isDeleted(false)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
            sysSemesters.add(sysSemester1);
        }
        sysSemesterRepository.saveAll(sysSemesters);
    }

    @Test
    void findAllSysSemester() {
        List<SysSemester> sysSemesters = sysSemesterRepository.findAllSysSemester();
        System.out.println(sysSemesters);
    }
}