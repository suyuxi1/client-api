package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.FleaGoodsDto;
import com.niit.soft.client.api.domain.dto.FleaSearchDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.FleaGoods;
import org.springframework.data.domain.Page;

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
    Page<FleaGoods> findFleaGoodsByContent(FleaSearchDto fleaSearchDto);

    /**
     * 根据时间分页查询商品
     *
     * @return
     */
    ResponseResult getGoodsByTime(PageDto pageDto);

    /**
     * 根据商品id查询指定商品信息；
     *
     * @param id Long
     * @return ResponseResult
     */
    ResponseResult findGoodById(Long id);

    /**
     * 修改商品
     *
     * @param fleaGoodsDto FleaGoodsDto
     * @return ResponseResult
     */
    ResponseResult updateGood(FleaGoodsDto fleaGoodsDto);

    /**
     * 下架商品
     *
     * @param goodId    Long
     * @param isDeleted Boolean
     * @return ResponseResult
     */
    ResponseResult soldOutGood(Boolean isDeleted, Long goodId);
}
