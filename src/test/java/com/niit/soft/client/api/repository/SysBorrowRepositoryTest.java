package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.SysBorrow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysBorrowRepositoryTest {

    @Resource
    private SysBorrowRepository sysBorrowRepository;
    @Test
    void findSysBorrowsByBorrowUserNumber() {
        List<SysBorrow> sysBorrows = sysBorrowRepository.findSysBorrowsByBorrowUserNumber("1802333117");
        System.out.println(sysBorrows);
    }

    @Test
    void findReturnSysBorrows() {
        List<SysBorrow> sysBorrows = sysBorrowRepository.findReturnSysBorrows("1802333117");
        System.out.println(sysBorrows);
    }

    @Test
    void countByBorrowUserNumber() {
        int count = sysBorrowRepository.countByBorrowUserNumber("1802333117");
        System.out.println(count);
    }
}