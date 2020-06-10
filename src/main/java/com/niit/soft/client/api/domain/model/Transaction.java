package com.niit.soft.client.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author wl
 * @ClassNametransaction
 * @Description TODO
 * @Date 2020/6/9
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     *订单id
     */
    @Column(name = "order_id", nullable = false)
    private  Long orderId;
    /**
     *交易创建时间+
     */
    @Column(name = "transaction_create", nullable = false)
    private LocalDateTime transactionCreate;
    /**
     *跑腿人
     *
     */
    @Column(name = "errands_id", nullable = false)
    private Long errandsId;
    /**完成时间  根据完成后更改
     *
     */
    @Column(name = "transaction_end", nullable = false)
    private LocalDateTime transactionEnd;
    /**
     *状态
     */
    @Column(name = "status", nullable = false)
    private  Integer status;
    /**
     * 创建时间
     */
    //@JsonIgnore
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
