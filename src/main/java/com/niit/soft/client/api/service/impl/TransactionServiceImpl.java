package com.niit.soft.client.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.TransactionDto;
import com.niit.soft.client.api.domain.model.DeliveryOrder;
import com.niit.soft.client.api.domain.model.Transaction;
import com.niit.soft.client.api.mapper.DeliveryOrderMapper;
import com.niit.soft.client.api.mapper.TransactionMapper;
import com.niit.soft.client.api.repository.TransactionRepository;
import com.niit.soft.client.api.service.TransactionService;
import com.niit.soft.client.api.util.SnowFlake;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author wl
 * @ClassNameTransactionServiceImpl
 * @Description TODO
 * @Date 2020/6/9
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class TransactionServiceImpl implements TransactionService {
    @Resource
    private TransactionRepository transactionRepository;
    @Resource
    private TransactionMapper transactionMapper;
    @Resource
    private DeliveryOrderMapper deliveryOrderMapper;

    @Override
    public ResponseResult insertTransaction(TransactionDto transactionDto) {
        SnowFlake snowFlake = new SnowFlake(1, 3);
        long transactionId = snowFlake.nextId();
        Transaction transaction = Transaction.builder().transactionCreate(LocalDateTime.now())
                .transactionEnd(LocalDateTime.now()).errandsId(transactionDto.getErrandsId()).status(0).orderId(transactionDto.getOrderId())
                .id(transactionId).gmtCreate(LocalDateTime.now()).gmtModified(LocalDateTime.now()).isDeleted(true).build();
        Transaction save = transactionRepository.save(transaction);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult finshOrder(Long orderId) {
        /**
         * 更新订单交易表的状态
         */
        QueryWrapper<Transaction> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        Transaction transaction = Transaction.builder().status(1).build();
        transactionMapper.update(transaction, queryWrapper);
        QueryWrapper<DeliveryOrder> deliveryOrderQueryWrapper = new QueryWrapper<>();
        deliveryOrderQueryWrapper.eq("id", orderId);
        DeliveryOrder deliveryOrder = DeliveryOrder.builder().isCancle(2).build();
        deliveryOrderMapper.update(deliveryOrder, deliveryOrderQueryWrapper);
        return ResponseResult.success();
    }


}