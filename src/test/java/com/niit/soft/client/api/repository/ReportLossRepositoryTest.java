package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.ReportLoss;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ReportLossRepositoryTest {
    @Resource
    private  ReportLossRepository reportLossRepository;
    @Test
    void  testFindAll(){
        List<ReportLoss> reportLosses=reportLossRepository.findAll();
        System.out.println(reportLosses);

    }

}