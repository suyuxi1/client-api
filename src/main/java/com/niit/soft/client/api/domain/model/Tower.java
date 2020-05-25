package com.niit.soft.client.api.domain.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Tower
 * @Description 科目实体类
 * @date 2020-05-25 21:59
 **/
@Entity
@Data
@Table(name = "tower",indexes = {@Index(name = "name_index",columnList = "name")})
public class Tower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_tower_id",nullable = false,columnDefinition = "主键")
    private Long pkTowerId;

    @Column(name = "name",nullable = false,length = 20,columnDefinition = "楼栋名")
    private String name	;

    @Column(name = "longitude",nullable = false,length = 20,columnDefinition = "精度")
    private String longitude;

    @Column(name = "latitude",nullable = false,length = 20,columnDefinition = "纬度")
    private String latitude;

    @Column(name = "type",nullable = false,length = 4,unique = true,columnDefinition = "类型（0 教学  1 宿舍楼   2 食堂）")
    private Boolean type;

    @Column(name = "gmt_create",nullable = false,columnDefinition = "创建时间")
    private Timestamp gmtCreate;

    @UpdateTimestamp
    @Column(name = "gmt_modified",nullable = false,columnDefinition = "更新时间")
    private Timestamp gmtModified;

    @Column(name = "is_deleted",nullable = false,length = 4,columnDefinition = "删除标志(0 未删除， 1 已删除)")
    private Boolean isDeleted;

}
