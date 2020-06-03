package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.ReportLoss;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName ReportLossRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/1
 **/
public interface ReportLossRepository extends JpaRepository<ReportLoss, Long> {
}