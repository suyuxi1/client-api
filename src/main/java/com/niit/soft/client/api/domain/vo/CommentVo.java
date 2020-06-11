package com.niit.soft.client.api.domain.vo;

import com.niit.soft.client.api.domain.model.ReplyComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName CommentVo
 * @Description 评论视图
 * @Author xiaobinggan
 * @Date 2020/6/8 2:56 下午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private Long pkCommentId;
    private Long dynamicId;
    private Long userId;
    private String content;
    private Timestamp gmtCreate;
    private Boolean isDeleted;
    //    private Comment comment;
    private List<ReplyComment> replyComments;
}
