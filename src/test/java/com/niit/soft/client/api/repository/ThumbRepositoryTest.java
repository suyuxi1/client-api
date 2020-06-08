package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Thumb;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
class ThumbRepositoryTest {

    @Resource
    private ThumbRepository thumbRepository;
    @Test
    void insertThumb(){
        Thumb thumb = Thumb.builder()
                .dynamicId(2L)
                .userId(2L)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .isDeleted(true)
                .build();
        thumbRepository.save(thumb);
    }

    @Test
    void deleteThumbByDynamicIdAndUserId() {
        thumbRepository.deleteByDynamicIdAndDynamicId(2L,2L);
    }
}