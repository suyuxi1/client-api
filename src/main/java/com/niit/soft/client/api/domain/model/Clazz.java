package com.niit.soft.client.api.domain.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Clazz
 * @Description TODO
 * @date 2020-05-25 22:02
 **/
@Entity
@Data
@Table(name = "clazz",indexes = {@Index(name = "nameIndex",columnList = "name"),
@Index(name = "college_idIndex",columnList = "college_id")})
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_clazz_id",nullable = false)
    private Long pkClazzId;

    @Column(name = "name",nullable = false,length = 32)
    private String name;

    @Column(name = "grade",nullable = false,length = 30)
    private String grade;

    @Column(name = "college_id",nullable = false)
    private Long collegeId;

    @Column(name = "clazz_headmaster",nullable = false,length = 20,unique = true)
    private String clazzHeadmaster;

    @UpdateTimestamp
    @Column(name = "gmt_modified",nullable = false)
    private Timestamp gmtModified;

    @Column(name = "gmt_create",nullable = false)
    private Timestamp gmtCreate;

    @Column(name = "is_deleted",nullable = false,length = 4)
    private Boolean isDeleted;
}
