package com.niit.soft.client.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FleaComment {
    /**
     * 评论id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkFleaCommentId;


    /**
     * 评论人
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaUser reviewer;

    /**
     * 被评论人
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaUser commentBy;


    /**
     * 评论内容
     */
    @Column(nullable = false)
    private String comment;


    /**
     * 该评论位于哪个悬赏（帖子）下
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaReward fleaReward;


    /**
     * 创建时间
     */
    @Column(nullable = false)
    private Timestamp createTime;



}
