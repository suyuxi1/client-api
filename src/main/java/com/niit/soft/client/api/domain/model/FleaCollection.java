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
public class FleaCollection {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkFleaCollectionId;


    /**
     * 用户id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaUser fleaUser;

    /**
     * 商品id
     */
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaGoods fleaGoods;

    /**
     * 收藏时间
     */
    @Column(nullable = false)
    private Timestamp createTime;



}
