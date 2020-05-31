package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.SysOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class OrderRepositoryTest {
@Resource
private OrderRepository orderRepository;
    @Test
    void findByJobNumber() {
 List<SysOrder> sysOrder =orderRepository.findAllByJobNumber("1802343315");
        System.out.println(sysOrder);
    }
}