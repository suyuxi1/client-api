package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaOrderRepository.java
 * @Description TODO
 * @createTime 2020年06月09日 13:53:00
 */
public interface FleaOrderRepository extends JpaRepository<FleaOrder,Long> {
}
