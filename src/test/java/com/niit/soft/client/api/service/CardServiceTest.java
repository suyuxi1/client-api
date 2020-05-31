package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.SysCard;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class CardServiceTest {
@Resource
private  CardService cardService;
    @Test
    void findAllByPage() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(4)
                .build();
        ResponseResult result = cardService.findAllByPage(pageDto);
        System.out.println(result);
    }

    @Test
    void  insertMore(){
        List<SysCard> sysCards = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            SysCard sysCard = SysCard.builder().cardNumber("18023433"+i)
                    .jobNumber("18023433"+i)
                    .cardPassword("123456")
                    .cardBalance(Double.valueOf(new Random().nextInt(1000)))
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now())).status(true).isDeleted(false).build()

                    ;
            sysCards.add(sysCard);
        }
        cardService.insertAll(sysCards);
    }
}