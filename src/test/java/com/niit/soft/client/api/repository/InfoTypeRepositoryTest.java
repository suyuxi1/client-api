package com.niit.soft.client.api.repository;

import com.alibaba.fastjson.JSON;
import com.niit.soft.client.api.domain.model.InfoManage;
import com.niit.soft.client.api.util.DataTypeChange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import javax.xml.transform.Source;


import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InfoTypeRepositoryTest {

    @Resource
    private InfoTypeRepository infoTypeRepository;
    @Resource
    private InfoManageRepository infoManageRepository;

//    @Test
//    void findInfoMangeByTypeId() {
//        Pageable pageable =  PageRequest.of(0,2);
////        Page<InfoManage> infoManages = infoManageRepository.findAll(pageable);
//        Page<Map> infoManages = infoTypeRepository.findInfoMangeByTypeId((long)1,pageable);
//        System.out.println(infoManages.getContent());
//    }


    /**
     * 分页查询
     */
    @Test
    void testFindInfoMangeByTypeId() {
        List<InfoManage> infoManages = infoTypeRepository.findInfoMangeByTypeId((long) 1, 1, 2);
        System.out.println(infoManages);
    }


    @Test
    void findInfoMangeByPage() {
        Pageable pageable = PageRequest.of(0,2,Sort.Direction.ASC,"pkInfoManageId");
        Page<InfoManage> infoManages = infoTypeRepository.findInfoMangeByPage((long)1,pageable);
        System.out.println(infoManages.getContent());
    }
}