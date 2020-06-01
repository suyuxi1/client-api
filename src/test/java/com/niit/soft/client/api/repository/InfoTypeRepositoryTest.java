package com.niit.soft.client.api.repository;

import com.alibaba.fastjson.JSON;
import com.niit.soft.client.api.domain.model.InfoType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Test
    void getTopById(){
        System.out.println(infoTypeRepository.getTopById(1L));
    }

    @Test
    void findInfoTypeByPkInfoTypeId() {
        List<Map<String,Object>> mapList = infoTypeRepository.findInfoByPkInfoTypeId(1L);
        System.out.println(mapList.get(0).get("pk_info_manage_id"));
        System.out.println(JSON.toJSON(mapList));

    }
}