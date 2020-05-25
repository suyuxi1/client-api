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
// * @ClassName sys_card
// * @Description TODO
// * @Author 田震
// * @Date 2020/5/25
// **/
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class SysCard {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long pkCardId;
//    @Column(nullable = false)
//    private String cardNumber;
//    @Column(nullable = false)
//    private  String cardPassword;
//    @Column(nullable = false)
//    private  String jobNumber;
//    @Column(nullable = false,unique = true)
//    private  Double cardBalance;
//    @Column(nullable = false)
//   private  Long status;
//    @Column(nullable = false)
//    private Timestamp gmtCreate;
//    @Column(nullable = false)
//    @CreationTimestamp
//    private  Timestamp gmtModified;
//    @Column(nullable = false)
//    private  Long isDeleted;
//
//
//}