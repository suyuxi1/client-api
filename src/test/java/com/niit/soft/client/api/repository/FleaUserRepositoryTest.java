package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaUser;
import com.niit.soft.client.api.domain.vo.FleaOrderVo;
import com.niit.soft.client.api.domain.vo.FleaUserVo;
import com.niit.soft.client.api.domain.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/11
 */
@Slf4j
@SpringBootTest
class FleaUserRepositoryTest {
    @Resource
    private FleaUserRepository fleaUserRepository;

    @Test
    void selectGoodsByUserId() {
//        List<GoodsVo> goodsVos = fleaUserRepository.selectGoodsByUserId(2L);
//        goodsVos.forEach(System.out::println);
    }

    @Test
    void selectOrderByUserId() {
//        List<FleaOrderVo> fleaOrderVos = fleaUserRepository.selectOrOrdersByUserId(4L);
//        fleaOrderVos.forEach(System.out::println);
    }

    @Test
    void selectUser() {
        FleaUser fleaUserVos = fleaUserRepository.findAllByJobNumber("1802343228");
        System.out.println(fleaUserVos);
    }
}