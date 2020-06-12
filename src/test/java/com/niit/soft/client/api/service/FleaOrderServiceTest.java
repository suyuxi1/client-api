package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.FleaOrderDto;
import com.niit.soft.client.api.repository.FleaOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FleaOrderServiceTest {
    @Autowired
    private FleaOrderRepository orderRepository;
    @Test
    void logicalDel() {
        FleaOrderDto fleaOrderDto = FleaOrderDto.builder()
                .fleaUserBuyerPkFleaUserId(3l)
                .fleaGoodsPkFleaGoodsId(13l)
                .build();
        System.out.println(orderRepository.logicalDel(fleaOrderDto));
    }
}