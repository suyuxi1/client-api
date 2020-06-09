package com.niit.soft.client.api.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Yujie_Zhao
 * @ClassName ThumbDto
 * @Description TODO
 * @Date 2020/6/8  14:47
 * @Version 1.0
 **/

@Data
@Builder
public class ThumbDto {
    /**
     * 被点在id
     */
    private Long dynamicId;

    /**
     * 用户id
     */
    private Long userId;
}
