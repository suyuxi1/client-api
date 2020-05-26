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
    @Column(name = "pk_semester_id", nullable = false)
    private Long pkSemesterId;

    @Column(name = "name" ,nullable = false,length = 32)
    private String name;

    @Column(name = "week_count" ,nullable = false)
    private Integer weekCount;

    @Column(name = "gmt_create" ,nullable = false)
    private Timestamp gmtCreate;

    @UpdateTimestamp
    @Column(name = "gmt_modified" ,nullable = false)
    private Timestamp gmtModified;

    @Column(name = "is_deleted" ,nullable = false,length = 4)
    private Boolean isDeleted;
}
