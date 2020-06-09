package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaType;
import com.niit.soft.client.api.domain.vo.GoodsVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaTypeRepository.java
 * @Description TODO
 * @createTime 2020年06月09日 13:55:00
 */
public interface FleaTypeRepository extends JpaRepository<FleaType,Long>  {
    /**
     * 根据分类ID查询商品
     * @param typeId
     * @return
     */
    @Query(value = "select new com.niit.soft.client.api.domain.vo.GoodsVo(g.goodsName,g.goodsPrice,g.goodsDescription,g.goodsMark,g.goodsImgUrl,g.goodsCreateTime,t.typeName,u.username)" +
            "from FleaGoods g " +
            "left join g.fleaType t " +
            "left join g.fleaUser u where t.pkFleaTypeId = ?1")
    List<GoodsVo> getGoodsByTypeId(Pageable pageable,Long typeId);
}
