package com.niit.soft.client.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName SysBorrow
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/25
 **/
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long pkBorrowId;
    @Column(nullable = false)
    private  String borrowUserName;
    @Column(nullable = false,unique = true)
    private  String borrowUserNumber;
    @Column(nullable = false)
    private  String borrowUserPhone;
    @Column(nullable = false)
    private String borrowBookName;
    @Column(nullable = false)
    private  String borrowBookId;
    @Column(nullable = false)
    private  Timestamp isReturned;
    @Column(nullable = false)
    private Timestamp gmtCreate;
    @Column(nullable = false)
    @CreationTimestamp
    private  Timestamp gmtModified;
    @Column(nullable = false)
    private  Long isDeleted;
}