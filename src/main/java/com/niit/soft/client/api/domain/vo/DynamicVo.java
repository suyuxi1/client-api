package com.niit.soft.client.api.domain.vo;

import com.niit.soft.client.api.domain.model.Comment;
import com.niit.soft.client.api.domain.model.Thumb;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName DynamicVo
 * @Description 动态资讯视图
 * @Author xiaobinggan
 * @Date 2020/6/8 2:54 下午
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DynamicVo {
    private Long pkDynamicId;
    private String title;
    private String content;
    private Integer thumbs;
    private Integer comments;
    private String type;
    private Timestamp gmtCreate;
    private Boolean isDeleted;
//    private Dynamic dynamic;
    private List<Comment> commentList;
    private List<Thumb> thumbList;
}
