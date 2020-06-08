package com.niit.soft.client.api.domain.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Yujie_Zhao
 * @ClassName Comment
 * @Description 校友圈动态评论
 * @Date 2020/6/8  14:00
 * @Version 1.0
 **/
@Entity
@Table(name = "comment")
public class Comment {

    /**
     * 主键，策略为自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkCommentId;


    /**
     * 动态id
     */
    @Column(name = "dynamic_id", nullable = false)
    private Long dynamicId;


    /**
     * 用户id
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 评论内容
     */
    @CreatedDate
    @Column(name = "content", nullable = false)
    private String content = "";

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @LastModifiedDate
    @Column(name = "gmt_modified")
    private Timestamp gmtModified;

    /**
     * 删除标志（0 未删除， 1 逻辑删除）
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 评论的评论
     */
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<ReplyComment> replyCommentList = new ArrayList<>();
}
