package com.niit.soft.client.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AlipayDto
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/5
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlipayDto {
   private   Double amount;
    private   String jobNumber;
    private  String rechargeType;
    private  Integer regexId ;

    /**
     * @author 倪涛涛
     * @version 1.0
     * @ClassName Admin
     * @Description TODO
     * @date 2020-06-09 14:19
     **/
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FleaSearchDto {
        private String content;
        private int currentPage;
        private int pageSize;
    }
}