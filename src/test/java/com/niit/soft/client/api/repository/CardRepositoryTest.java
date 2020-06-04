package com.niit.soft.client.api.repository;

import cn.hutool.core.util.RandomUtil;
import com.niit.soft.client.api.domain.model.SysCard;
import com.niit.soft.client.api.domain.model.SysOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class CardRepositoryTest {
    @Resource
    private  CardRepository cardRepository;
    @Resource
    private  OrderRepository orderRepository;

    @Test
    void TestFindAll() {
        List<SysCard> findAll=cardRepository.findAll();
        System.out.println(findAll);
    }
    @Test
    public  void TestFindAll1() throws Exception{
        int page=1,size=2;
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "cardBalance"));
        cardRepository.findALL(pageable);
        System.out.println(cardRepository.findALL(pageable));
    }
    @Test
    void  insertMore(){
        List<SysCard> sysCards = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            SysCard sysCard = SysCard.builder().cardNumber("18023433"+i)
                    .jobNumber("18023433"+i)
                    .cardPassword("123456")
                    .cardBalance(Double.valueOf(new Random().nextInt(1000)))
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now())).status(true).isDeleted(false).build()

                    ;
            sysCards.add(sysCard);
        }
        cardRepository.saveAll(sysCards);
    }

    @Test
    void findCardBalanceByJobNumber() {
        Double card_balance=cardRepository.findCardBalanceByJobNumber("180234331");
        System.out.println(card_balance);
    }

    @Test
    void updateCardBalanceCardNumber() {
        int a=cardRepository.insertCardBalance("1802343315",190.5);
        System.out.println(a);
    }

    @Test
    void insertelectricityBalance() {
        int a =cardRepository.insertelectricityBalance( "雪松苑-A4-113",50.0);
        SysOrder sysOrder=
                SysOrder.builder().description("雪松苑-A4-113"+"电费充值").orderMoney(80.0).orderNumber(
                        "10"+RandomUtil.randomInt(800,10000)).isDeleted(false).gmtCreate(Timestamp.valueOf(LocalDateTime.now())).orderType("充值").payMethod("校园卡消费").status(true).build();
        orderRepository.save(sysOrder);
        System.out.println(a);
    }
}