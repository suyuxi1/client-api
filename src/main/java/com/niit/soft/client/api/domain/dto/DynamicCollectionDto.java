package com.niit.soft.client.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName DynamicCollectionDto
 * @Description TODO
 * @Date 2020/6/11  23:07
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DynamicCollectionDto {
    /**
     * 动态内容
     */
    private String content;

    /**
     * 动态配图
     */
    private List<String> picture;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 动态创建时间
     */
    private Timestamp gmtCreate;
}
