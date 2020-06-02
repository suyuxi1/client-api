package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.domain.model.SysBorrow;
import com.niit.soft.client.api.repository.SysBorrowRepository;
import com.niit.soft.client.api.service.SysBorrowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysBorrowServiceImpl
 * @Description TODO
 * @date 2020-06-02 9:30
 **/
@Service
public class SysBorrowServiceImpl implements SysBorrowService {
    @Resource
    private SysBorrowRepository sysBorrowRepository;

    @Override
    public ResponseResult findSysBorrowsByBorrowUserNumber(String borrowUserNumber) {
        List<SysBorrow> sysBorrows = sysBorrowRepository.findSysBorrowsByBorrowUserNumber(borrowUserNumber);
        if(sysBorrows!=null){
            return ResponseResult.success(sysBorrows);
        }else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public ResponseResult countByBooks(String borrowUserNumber) {
        int count = sysBorrowRepository.countByBorrowUserNumber(borrowUserNumber);
        return ResponseResult.success(count);
    }
}
