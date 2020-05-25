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
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false,length = 10)
    private String name;

    @Column(nullable = false,unique = true)
    private Long towerId;

    @Column(nullable = false,length = 20,unique = true)
    private String roomLeaderJobNumber;

    @Column(nullable = false,unique = true)
    private String roomMemberJobNumber;

    @Column(nullable = false)
    private Timestamp gmtCreate;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp gmtModified;

    @Column(nullable = false)
    private Boolean isDeleted;

}
