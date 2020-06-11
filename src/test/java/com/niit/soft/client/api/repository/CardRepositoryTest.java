package com.niit.soft.client.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CardRepositoryTest {
@Resource
private CardRepository cardRepository;
    @Test
    void insertBalance() {
        System.out.println(cardRepository.insertBalance("1802343315",100.15));
    }

    @Test
    void testInsertBalance() {
        System.out.println(cardRepository.insertBalance("1802343315",88.92));
    }
}