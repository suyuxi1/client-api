package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.Message;
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
class MessageRepositoryTest {
    @Resource
    private MessageRepository messageRepository;

    /**
     * 存储一些消息数据
     */
    @Test
    void insertMessage() {
        List<Message> messages = new ArrayList<>();
        for (int i =1 ; i<=50 ;i++){
            Message message = Message.builder()
                    .pkMessageId(Long.valueOf(i))
                    .content("测试内容第"+i+"篇信息")
                    .isReaded(false)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
            messages.add(message);
        }
        messageRepository.saveAll(messages);
    }

    /**
     * 分页查询Message数据
     */
    @Test
    void findAll() {
        Pageable pageable = PageRequest.of(1,2, Sort.Direction.DESC,"pkMessageId");
        Page<Message> messagePage = messageRepository.findAll(pageable);
        System.out.println(messagePage.getContent());
    }

    @Test
    void updateIsReaded() {
        int a = messageRepository.updateIsReaded(Long.valueOf(1));
        System.out.println(a);
    }
}