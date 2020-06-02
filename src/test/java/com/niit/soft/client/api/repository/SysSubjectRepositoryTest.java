package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.dto.SysSubject1;
import com.niit.soft.client.api.domain.model.SysSubject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.persistence.Tuple;
import java.util.List;

@SpringBootTest
class SysSubjectRepositoryTest {

    @Resource
    private SysSubjectRepository sysSubjectRepository;


    @Test
    void testFindSysSubjectByPkSubjectId() {
        SysSubject sysSubject = sysSubjectRepository.findSysSubjectByPkSubjectId((long)1);
        System.out.println(sysSubject);
    }

    @Test
    void selectSysSubjectById() {
        List<Tuple> tuples = sysSubjectRepository.selectSysSubjectById((long)1);
        tuples.stream().map(tuple -> {
            return  tuple.get(0,String.class)+","+
                tuple.get(1,String.class)+","+
                tuple.get(2,String.class);
    }).forEach(System.out::println);
    }

    @Test
    void selectSubject() {
        List<SysSubject1> sysSubjects = sysSubjectRepository.selectSubject((long)1);
        sysSubjects.forEach(sysSubject->{
            System.out.println(sysSubject.getCover()+sysSubject.getName()+sysSubject.getBackgroundColor());
        });
    }
}