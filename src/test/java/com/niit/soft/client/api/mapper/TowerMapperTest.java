package com.niit.soft.client.api.mapper;

import com.niit.soft.client.api.domain.vo.DormVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TowerMapperTest {

    @Resource
    private TowerMapper towerMapper;
    @Test
    void getAllDormByType() throws SQLException{
        List<DormVo> dormVos = towerMapper.getAllDormByType();
        System.out.println(dormVos);
    }
}