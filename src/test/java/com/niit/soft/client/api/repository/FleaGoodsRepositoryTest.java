package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaGoods;
import com.niit.soft.client.api.domain.vo.MarkVo;
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
@SpringBootTest
@Slf4j
class FleaGoodsRepositoryTest {
    @Resource
    private FleaGoodsRepository goodsRepository;

    @Test
    void selectTopFiveMark() {
        System.out.println(goodsRepository.selectTopFiveMark());
    }
}