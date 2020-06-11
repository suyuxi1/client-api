package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.dto.FleaUserDto;
import com.niit.soft.client.api.domain.dto.UpdateFleaUserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/10
 */
@SpringBootTest
@Slf4j
class FleaUserServiceTest {
    @Resource
    private FleaUserService fleaUserService;

    @Test
    void saveFleaUser() {
        FleaUserDto fleaUserDto = new FleaUserDto();
        fleaUserDto.setJobNumber("1802343116");
        System.out.println(fleaUserService.saveFleaUser(fleaUserDto));
    }

    @Test
    void flushFleaUser() {
        UpdateFleaUserDto updateFleaUserDto = UpdateFleaUserDto.builder()
                .avatar("https://kxingchen.oss-cn-shanghai.aliyuncs.com/develop/20200420204619.png")
                .nickname("hn丶巴德尔").phoneNumber("18932386185").pkFleaUserId(2L).sex("男")
                .build();
        System.out.println(fleaUserService.updateFleaUser(updateFleaUserDto));
    }
}