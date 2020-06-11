package com.niit.soft.client.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wl
 * @ClassNamedeliveryOrder
 * @Description TODO
 * @Date 2020/6/9
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "delivery_order")
public class DeliveryOrder {
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * 订单发起人
     */
    @Column(name = "founder_id", nullable = false)
    private Long founderId;
    /**
     * 初始位置
     */
    @Column(name = "origin_address", nullable = false)
    private String originAddress;
    /**
     * 出发地纬度
     */
    @Column(name = "o_longitude", nullable = false)
    private String oLongitude;
    /**
     * 出发地经度
     */
    @Column(name = "o_dimension", nullable = false)
    private String oDimension;
    /**
     * 目的地
     */
    @Column(name = "destination", nullable = false)
    private String destination;
    /**
     * 目的地经度
     */
    @Column(name = "d_longitude", nullable = false)
    private String dLongitude;
    /**
     * 目的地维度
     */
    @Column(name = "d_dimension", nullable = false)
    private String dDimension;
    /**
     * 商品详细信息
     */
    @Column(name = "commodity_id", nullable = false)
    private Long commodityId;
    /**
     * 订单创建时间
     */
    @Column(name = "oder_create_time", nullable = false)
    private LocalDateTime oderCreateTime;
    /**
     * 送出时间（立即送出 或者指定时间）
     */
    @Column(name = "delivery_time", nullable = false)
    private LocalDateTime deliveryTime;
    /**
     * 0  1 是否取消
     */
    @Column(name = "is_cancle", nullable = false)
    private Integer isCancle;
    /**
     * 订单金额（起步价格6）
     */
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    /**
     * 收货人名字
     */
    @Column(name = "receiver_name", nullable = false)
    private String receiverName;
    /**
     * 收货人手机号
     */
    @Column(name = "receiver_phoneNumber", nullable = false)
    private String receiverPhoneNumber;
    /**
     * 备注
     */
    @Column(name = "remark", nullable = false)
    private String remark;
    /**
     * 创建时间
     */
    @JsonIgnore
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime gmtModified;

    /**
     * 删除标志（0 逻辑删除， 1 未删除）
     */
//    @JsonIgnore
    @Column(nullable = false, length = 4)
    private Boolean isDeleted;

}
