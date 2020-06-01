package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.InfoManage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@SpringBootTest
@Slf4j
class InfoManageRepositoryTest {

    @Resource
    private InfoManageRepository infoManageRepository;

    @Test
    void testSave() {
//        InfoManage infoManage = InfoManage.builder()
//                .title("测试1")
//                .cover("1.jpg")
//                .text("测试内容")
//                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
//                .isDeleted(true)
//                .build();
//        infoManageRepository.save(infoManage);

        List<InfoManage> infoManages = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            InfoManage test = InfoManage.builder()
                    .title("测试"+i)
                    .cover(i+".jpg")
                    .isTop(false)
                    .text("测试内容"+i)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(true)
                    .build();
            infoManages.add(test);
        }
        infoManageRepository.saveAll(infoManages);
    }

    @Test
    void testSelectAll() {
        List<InfoManage> list1 = infoManageRepository.findAll();
        log.info(String.valueOf(list1.size()));
    }
    @Test
    void getIsTopInfo() {
        List<InfoManage> infoManages = infoManageRepository.getIsTopInfo();
        infoManages.forEach(System.out::println);
//        log.info(String.valueOf(infoManages.size()));
    }

    @Test
    void getInfoByType() {
//        System.out.println("得到："+infoMangeTypeRepository.getInfoByType(1L).toString());
        List<InfoManage> mapList =infoManageRepository.getInfoByType(1L);
        mapList.forEach(map->{
            System.out.println(map);
        });
    }

    @Test
    void getInfoManageByPkInfoManageId() {
        System.out.println(infoManageRepository.getInfoManageByPkInfoManageId(2L));
    }

    @Test
    void getAllManage() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(4)
                .build();
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pk_info_manage_id");
        Page<InfoManage> infoManagePage = infoManageRepository.getAllManage(pageable);
        System.out.println(infoManagePage);
    }
}