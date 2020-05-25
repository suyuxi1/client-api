//package com.niit.soft.client.api.domain.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
///**
// * @ClassName ReportLoss
// * @Description TODO
// * @Author 田震
// * @Date 2020/5/25
// **/
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class ReportLoss {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long pkReportLossId;
//    @Column
//    private  String remark;
//    @Column(nullable = false)
//    private  String password;
//    @Column(nullable = false)
//    private  Long lossStatus;
//    @Column(nullable = false,unique = true)
//    private  String lossPhone;
//    @Column(nullable = false)
//    private  String lossName;
//    @Column(nullable = false,unique = true)
//    private String  lossJobNumber;
//    @Column(nullable = false)
//    private Timestamp gmtCreate;
//    @Column(nullable = false)
//    private  Timestamp gmtModified;
//    @Column(nullable = false)
//    private  Long isDeleted;
//}