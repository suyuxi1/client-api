package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.vo.FleaGoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class FleaGoodsRepositoryTest {
    @Resource
    private FleaGoodsRepository fleaGoodsRepository;
    @Test
    void getAllGoodsByTime() {
        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC,"goodsCreateTime");
        System.out.println(fleaGoodsRepository.getAllGoodsByTime(pageable));
    }

    @Test
    void selectGoodsById() {
        List<FleaGoodsVo> fleaGoodsVos = fleaGoodsRepository.selectGoodsById(5L);
        fleaGoodsVos.forEach(System.out::println);
    }

    @Test
    void soldOutGood() {
        System.out.println(fleaGoodsRepository.soldOutGood(true,4L));
    }
}