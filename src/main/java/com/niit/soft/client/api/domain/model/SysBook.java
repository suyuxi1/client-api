//package com.niit.soft.client.api.domain.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
///**
// * @ClassName SysBook
// * @Description TODO
// * @Author 田震
// * @Date 2020/5/25
// **/
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class SysBook {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  Long pkBookId;
//    private  String author;
//    @Column(nullable = false,unique = true)
//    private  String cover;
//    @Column(nullable = false)
//    private  String type;
//    @Column(nullable = false)
//    private  String description;
//    @Column(nullable = false)
//    private  Integer bookNumber;
//    @Column(nullable = false)
//    private  Integer bookResidueNumber;
//    @Column(nullable = false)
//    private  Long status;
//    @Column(nullable = false,unique = true)
//    private  String bookName;
//    @Column(nullable = false)
//    private Timestamp gmtCreate;
//    @Column(nullable = false)
//    @CreationTimestamp
//    private  Timestamp gmtModified;
//    @Column(nullable = false)
//    private  Long isDeleted;
//}