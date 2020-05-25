package com.niit.soft.client.api.domain.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author Tao
 */
@Entity
@Data
public class SysSemester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_semester_id", nullable = false,columnDefinition = "主键")
    private Long pkSemesterId;

    @Column(name = "name" ,nullable = false,length = 32,columnDefinition = "名称")
    private String name;

    @Column(name = "week_count" ,nullable = false,length = 11,columnDefinition = "周次数")
    private Integer weekCount;

    @Column(name = "gmt_create" ,nullable = false,columnDefinition = "创建时间")
    private Timestamp gmtCreate;

    @UpdateTimestamp
    @Column(name = "gmt_modified" ,nullable = false,columnDefinition = "更新时间")
    private Timestamp gmtModified;

    @Column(name = "is_deleted" ,nullable = false,length = 4,columnDefinition = "删除标志(0 未删除， 1 逻辑删除)")
    private Boolean isDeleted;
}
