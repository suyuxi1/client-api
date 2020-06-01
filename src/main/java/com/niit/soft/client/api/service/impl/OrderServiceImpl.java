package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.SysOrder;
import com.niit.soft.client.api.repository.OrderRepository;
import com.niit.soft.client.api.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/29
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Override
    public ResponseResult findALLByJobNumer(String jobNumber) {
        List<SysOrder> sysOrderList=orderRepository.findAllByJobNumber(jobNumber);

        return ResponseResult.success(sysOrderList);
    }

    @Override
    public ResponseResult findAllByPage(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkCardId");
        Page<SysOrder> sysOrders = orderRepository.findAll(pageable);
        return ResponseResult.success(sysOrders.getContent());
    }
}