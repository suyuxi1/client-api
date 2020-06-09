package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaGoods;
import com.niit.soft.client.api.domain.model.FleaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsRepository.java
 * @Description TODO
 * @createTime 2020年06月09日 13:53:00
 */
public interface FleaGoodsRepository extends JpaRepository<FleaGoods, Long> {

    /**
     * 根据搜索内容进行模糊查询
     * @param goodsName
     * @param goodsDescription
     * @return
     */
    List<FleaGoods> findFleaGoodsByGoodsNameLikeOrGoodsDescriptionLike(String goodsName, String goodsDescription);

}
