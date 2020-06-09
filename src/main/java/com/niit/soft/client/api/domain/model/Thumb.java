package com.niit.soft.client.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Yujie_Zhao
 * @ClassName Thumb
 * @Description 校友圈动态点赞
 * @Date 2020/6/8  14:01
 * @Version 1.0
 **/
@Entity
@Table(name = "Thumb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Thumb {
    /**
     * 主键，策略为自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkThumbId;


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
     * 创建时间
     */
    //@JsonIgnore
    @Column(nullable = false)
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp gmtModified;

    /**
     * 删除标志（0 逻辑删除， 1 未删除）
     */
//    @JsonIgnore
    @Column(nullable = false, length = 4)
    private Boolean isDeleted;

}
