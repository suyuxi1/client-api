
package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.dto.CollectionDto;
import com.niit.soft.client.api.domain.model.FleaCollection;
import com.niit.soft.client.api.domain.vo.CollectionVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName a.java
 * @Description TODO
 * @createTime 2020年06月09日 11:26:00
 */
public interface FleaCollectionRepository extends JpaRepository<FleaCollection, Long> {
    @Query(value = "select new com.niit.soft.client.api.domain.vo.CollectionVo(g.goodsName,g.goodsDescription,g.goodsPrice,g.goodsImgUrl,g.goodsMark,u.username,u.phoneNumber,c.createTime)" +
            "from FleaCollection c " +
            "left join c.fleaGoods g " +
            "left join c.fleaUser u")
    List<CollectionVo> getCollection();
}
