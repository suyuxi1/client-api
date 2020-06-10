package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaUserRepository.java
 * @Description TODO
 * @createTime 2020年06月09日 13:54:00
 */
public interface FleaUserRepository extends JpaRepository<FleaUser,Long> {
}

