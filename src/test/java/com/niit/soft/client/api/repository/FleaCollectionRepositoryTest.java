package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.dto.CancelCollectionDto;
import com.niit.soft.client.api.domain.dto.CollectionDto;
import com.niit.soft.client.api.domain.model.FleaCollection;
import com.niit.soft.client.api.domain.model.FleaGoods;
import com.niit.soft.client.api.domain.model.FleaUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FleaCollectionRepositoryTest {
    @Resource
    private FleaCollectionRepository collectionRepository;
    @Resource
    private FleaGoodsRepository fleaGoodsRepository;
    @Resource
    private FleaUserRepository fleaUserRepository;

    @Test
    void insert() {
        CollectionDto collectionDto = new CollectionDto();
        collectionDto.setGoodsId(5l);
        collectionDto.setUserId(3l);
        FleaGoods fleaGoods = fleaGoodsRepository.findById(collectionDto.getGoodsId()).get();
        FleaUser fleaUser = fleaUserRepository.findById(collectionDto.getUserId()).get();
        FleaCollection fleaCollection = FleaCollection.builder()
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .fleaGoods(fleaGoods)
                .fleaUser(fleaUser)
                .isDeleted(false).
                        build();
        System.out.println(collectionRepository.save(fleaCollection));

    }
    @Test
    void getAll(){
        System.out.println(collectionRepository.getCollection());
    }

    @Test
    void logicalDel() {
        CancelCollectionDto collectionDto = new CancelCollectionDto();
        collectionDto.setGoodsId(4l);
        collectionDto.setUserId(3l);
        System.out.println(collectionRepository.logicalDel(collectionDto));
    }
}