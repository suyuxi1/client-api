package com.niit.soft.client.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yujie_Zhao
 * @ClassName DynamicCollectionInDto
 * @Description TODO
 * @Date 2020/6/12  8:24
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DynamicCollectionInDto {
    private Long dynamicId;
    private Long userId;
}
