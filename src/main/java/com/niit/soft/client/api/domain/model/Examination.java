package com.niit.soft.client.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Yujie_Zhao
 * @ClassName Examination
 * @Description 考务实体类
 * @Date 2020/5/25  22:22
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "examination",indexes = {@Index(name = "clazz_idIndex",columnList = "clazz_id")})
public class Examination {
    /**
     * 主键，策略为自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkExaminationId;

    /**
     * 学期
     * nullable = false为非空约束，unique = true是唯一约束
     */
    @Column(nullable = false, unique = true,length = 60)
    private String semester;

    /**
     * 科目id
     */
    @Column(nullable = false, unique = true ,length = 60)
    private String subjectId;
    /**
     * 班级id
     */
    @Column(name = "clazz_id",nullable = false, unique = true ,length = 11)
    private Integer clazzId;

    /**
     * 监考老师
     */
    @Column(nullable = false, unique = true ,length = 32)
    private String teacherName;

    /**
     * 开始时间
     */
    @Column(nullable = false, unique = true )
    private String startTime;

    /**
     * 地点
     */
    @Column(nullable = false, unique = true)
    private String area;

    /**
     * 试卷分数
     */
    @Column(nullable = false, unique = true ,length = 4)
    private Integer score;

    /**
     * 考试类型
     */
    @Column(nullable = false, unique = true ,length = 32)
    private String type;

    /**
     * 创建时间
     */
    @Column(nullable = false, unique = true)
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @UpdateTimestamp
    @Column(nullable = false, unique = true)
    private Timestamp gmtModified;

    /**
     * 删除标志（0 逻辑删除， 1 未删除）
     */
    @Column(nullable = false, unique = true,length = 4)
    private Boolean isDeleted;

}
