package com.niit.soft.client.api.domain.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Room
 * @Description TODO
 * @date 2020-05-25 21:48
 **/
@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,columnDefinition = "主键")
    private Long id;

    @Column(name = "name",nullable = false,length = 10,columnDefinition = "房间名")
    private String name;

    @Column(name = "tower_id",nullable = false,unique = true,columnDefinition = "楼栋id")
    private Long towerId;

    @Column(name = "room_leader_job_number",nullable = false,length = 20,unique = true,columnDefinition = "寝室长学号")
    private String roomLeaderJobNumber;

    @Column(name = "room_member_job_number",nullable = false,unique = true,columnDefinition = "寝室成员学号（逗号隔开，用户学号）")
    private String roomMemberJobNumber;

    @Column(name = "gmt_create",nullable = false,columnDefinition = "创建时间")
    private Timestamp gmtCreate;

    @UpdateTimestamp
    @Column(name = "gmt_modified",nullable = false,columnDefinition = "更新时间")
    private Timestamp gmtModified;

    @Column(name = "is_deleted",nullable = false,length = 4,columnDefinition = "删除标志（0 未删除， 1 已删除）")
    private Boolean isDeleted;

}
