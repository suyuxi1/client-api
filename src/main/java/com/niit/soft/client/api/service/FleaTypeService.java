package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import org.springframework.data.domain.Pageable;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsService.java
 * @Description TODO
 * @createTime 2020年06月09日 13:58:00
 */
public interface FleaTypeService {
    /**
     * 根据分类id查询商品
     * @param typeId
     * @return
     */
    ResponseResult getGoodsByType(PageDto pageDto, Long typeId);
}
