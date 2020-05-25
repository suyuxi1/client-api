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
// * @ClassName sys_order
// * @Description TODO
// * @Author 田震
// * @Date 2020/5/25
// **/
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class SysOrder {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  Integer pkOrderId;
//    @Column(nullable = false)
//    private  String jobNumber;
//    @Column(nullable = false)
//    private  String orderType;
//    @Column(nullable = false)
//    private  Double orderMoney;
//    @Column(nullable = false)
//    private  String orderNumber;
//    @Column(nullable = false)
//    private  Long status;
//    @Column
//    private  String description;
//    @Column(nullable = false)
//    private  String payMethod;
//    @Column(nullable = false)
//    private Timestamp gmtCreate;
//    @Column(nullable = false)
//    @CreationTimestamp
//    private  Timestamp gmtModified;
//    @Column(nullable = false)
//    private  Long isDeleted;
//}