package com.niit.soft.client.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yhChen
 * @Description 下架商品Dto
 * @Date 2020/6/10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SoldOutGoodDto {
    /**
     * 删除标志
     */
    private Boolean isDeleted;

    /**
     * 商品id
     */
    private Long pkFleaGoodsId;
}
