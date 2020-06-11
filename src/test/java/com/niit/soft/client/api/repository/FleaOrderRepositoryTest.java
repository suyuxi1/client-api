package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.dto.FleaOrderDto;
import com.niit.soft.client.api.domain.model.FleaOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@SpringBootTest
class FleaOrderRepositoryTest {
    @Autowired
    private FleaOrderRepository orderRepository;
    @Test
    void del(){
//        FleaOrderDto orderDto = FleaOrderDto
//                .builder()
//                .buyerId(3l)
//                .goodsId(16l)
//                .sellerId(1l)
//                .build();
//        FleaOrder fleaOrder = FleaOrder.builder()
//                .createTime(Timestamp.valueOf(LocalDateTime.now()))
//                .fleaGoods(goodsRepository.findById(orderDto.getGoodsId()).get())
//                .fleaUserBuyer(userRepository.findById(orderDto.getBuyerId()).get())
//                .fleaUserSeller(userRepository.findById(orderDto.getSellerId()).get())
//                .isDeleted(false)
//                .pkFleaOrderId(202006111358l)
//                .build();
//        System.out.println(orderRepository.save(fleaOrder));
        FleaOrderDto fleaOrderDto = FleaOrderDto.builder()
                .fleaGoodsPkFleaGoodsId(9l)
                .fleaUserBuyerPkFleaUserId(5l)
                .build();
        System.out.println(orderRepository.logicalDel(fleaOrderDto));
    }
}