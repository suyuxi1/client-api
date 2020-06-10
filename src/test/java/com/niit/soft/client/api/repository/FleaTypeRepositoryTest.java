package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.dto.TypeDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FleaTypeRepositoryTest {
    @Resource
    private FleaTypeRepository fleaTypeRepository;
    @Test
    void getGoodsByTypeId() {
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC,"goodsCreateTime");
        TypeDto typeDto = new TypeDto();
        typeDto.setCurrentPage(0);
        typeDto.setPageSize(10);
        typeDto.setTypeId(2l);
        System.out.println(typeDto.getTypeId());
        System.out.println(fleaTypeRepository.getGoodsByTypeId(pageable,typeDto));
    }
}