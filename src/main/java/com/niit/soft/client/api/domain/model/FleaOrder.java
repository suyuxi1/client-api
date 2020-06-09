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
public class FleaOrder {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkFleaOrderId;

    /**
     * 商品id
     */
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaGoods fleaGoods;

    /**
     * 买方id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaUser fleaUserBuyer;
    /**
     * 卖方id
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private FleaUser fleaUserSeller;
    /**
     * 创建时间
     */
    @Column(nullable = false)
    private Timestamp createTime;



}
