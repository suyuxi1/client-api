package com.niit.soft.client.api.domain.dto;

/**
 * 描述:
 *新增订单传参类
 * @author：Guorc
 * @create 2020-06-11 13:43
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FleaOrderDto {
    private Long goodsId;
    private Long sellerId;
    private Long buyerId;
}
