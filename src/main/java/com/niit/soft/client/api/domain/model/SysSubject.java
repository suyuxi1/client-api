package com.niit.soft.client.api.domain.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysSubject
 * @Description 科目表
 * @date 2020-05-25 22:07
 **/
@Entity
@Data
public class SysSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_subject_id",nullable = false,columnDefinition = "主键")
    private Long pk_subject_id;

    @Column(name = "name",nullable = false,length = 20,columnDefinition = "名称")
    private String name;

    @Column(name = "type",nullable = false,length = 20,columnDefinition = "课程类型")
    private String type;

    @Column(name = "cover",nullable = false,columnDefinition = "科目图片")
    private String cover;

    @Column(name = "gmt_create",nullable = false,columnDefinition = "创建时间")
    private Timestamp gmt_create;

    @UpdateTimestamp
    @Column(name = "gmt_modified",nullable = false,columnDefinition = "修改时间")
    private Timestamp gmt_modified;

    @Column(name = "is_deleted",nullable = false,length = 4,columnDefinition = "删除标志(0 未删除， 1 逻辑删除)")
    private Boolean isDeleted;
}
