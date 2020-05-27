package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.InfoType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class InfoTypeRepositoryTest {

    @Resource
    private InfoTypeRepository infoTypeRepository;


    @Test
    void getAllTyp() {
        List<InfoType> infoTypes = infoTypeRepository.findAll();
        System.out.println(infoTypes);
    }
}