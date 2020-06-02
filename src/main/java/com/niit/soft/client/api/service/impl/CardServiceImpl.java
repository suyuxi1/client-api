package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.SysCard;
import com.niit.soft.client.api.repository.CardRepository;
import com.niit.soft.client.api.service.CardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CardServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/26
 **/
@Service
public class CardServiceImpl implements CardService {
    @Resource
   private CardRepository cardRepository;

    @Override
    public ResponseResult findAllByPage(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkCardId");
        Page<SysCard> sysCards = cardRepository.findAll(pageable);
        return ResponseResult.success(sysCards.getContent());
    }

    @Override
    public ResponseResult insertAll(List<SysCard> sysCards) {
        List<SysCard> sysCardList=new ArrayList<>();
        return ResponseResult.success(sysCardList);
    }

    @Override
    public ResponseResult selectCardBalance(String jobNumber) {
        Double cardBalance=cardRepository.findCardBalanceByJobNumber(jobNumber);
        return ResponseResult.success(cardBalance);
    }

    @Override
    public ResponseResult insertCardBalance(String cardNumber, Double money) {
        int a=cardRepository.insertCardBalance(cardNumber,money);
        return ResponseResult.success(a);
    }
}