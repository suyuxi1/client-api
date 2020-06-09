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
public class FleaReward {
    /**
     * 悬赏Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkRewardId;

    /**
     * 描述
     */
    @Column(nullable = false)
    private String description;

    /**
     * 图片地址
     */
    @Column(nullable = false)
    private String imageUrl;


    /**
     * 标题
     */
    @Column(nullable = false, length = 50)
    private String title;


    /**
     * 发布时间
     */
    @Column(nullable = false)
    private Timestamp createTime;


    /**
     * 发布人
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaUser fleaUser;
}
