package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaTypeRepository.java
 * @Description TODO
 * @createTime 2020年06月09日 13:55:00
 */
public interface FleaTypeRepository extends JpaRepository<FleaType,Long>  {
}
