package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;

/**
 * @author Tao
 */
public interface SysBorrowService {
    /**
     * 查询所有图书信息
     * @param borrowUserNumber
     * @return
     */
    ResponseResult findSysBorrowsByBorrowUserNumber(String borrowUserNumber);

    /**
     * 计数
     * @param borrowUserNumber
     * @return
     */
    ResponseResult countByBooks(String borrowUserNumber);
}
