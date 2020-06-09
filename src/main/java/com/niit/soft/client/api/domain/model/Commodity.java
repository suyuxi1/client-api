package com.niit.soft.client.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author wl
 * @ClassNamecommodity
 * @Description TODO
 * @Date 2020/6/9
 * @Version 1.0
 */
@Table(name = "commodity")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commodity {
    /**
     * 主键自增
     */
    @Id

    @Column(name = "id")
    private Long id;
    /**
     * 商品类型
     */
    @Column(name = "type", nullable = false)
    private String type;
    /**
     * 物品价格范围
     */
    @Column(name = "price_rang", nullable = false)
    private String priceRang;
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
