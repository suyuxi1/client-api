package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaReward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName a.java
 * @Description TODO
 * @createTime 2020年06月09日 11:26:00
 */
public interface FleaRewardRepository extends JpaRepository<FleaReward, Long> {
    List<FleaReward> findFleaRewardsByDescriptionLikeOrTitleLike(String description, String title);
}
