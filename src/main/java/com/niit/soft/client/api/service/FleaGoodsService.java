package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsService.java
 * @Description TODO
 * @createTime 2020年06月09日 13:58:00
 */
public interface FleaGoodsService {
    /**
     * 模糊查询所有商品
     */
    List<FleaGoodsService> findFileGoodsByContent(String content);

    /**
     * 根据时间分页查询商品
     * @return
     */
    ResponseResult getGoodsByTime(PageDto pageDto);
}
