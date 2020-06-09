package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.FleaGoods;
import com.niit.soft.client.api.domain.vo.FleaGoodsVo;
import com.niit.soft.client.api.domain.vo.GoodsVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     *
     * @param goodsName
     * @param goodsDescription
     * @return
     */
    List<FleaGoods> findFleaGoodsByGoodsNameLikeOrGoodsDescriptionLike(String goodsName, String goodsDescription);

    @Query(value = "select new com.niit.soft.client.api.domain.vo.GoodsVo(g.goodsName,g.goodsPrice,g.goodsDescription,g.goodsMark,g.goodsImgUrl,g.goodsCreateTime,t.typeName,u.username)" +
            "from FleaGoods g " +
            "left join g.fleaType t " +
            "left join g.fleaUser u")
    List<GoodsVo> getAllGoodsByTime(Pageable pageable);

    /**
     * 根据商品id查询指定商品的详细信息
     *
     * @param goodId Long
     * @return List<FleaGoodsVo>
     */
    @Query(value = "select new com.niit.soft.client.api.domain.vo.FleaGoodsVo(g.pkFleaGoodsId,g.goodsName,g.goodsDescription,g.goodsImgUrl,g.goodsPrice,g.goodsMark," +
            "g.goodsCreateTime,t.pkFleaTypeId,t.typeName,u.pkFleaUserId,u.nickname,u.username) " +
            "from FleaGoods g " +
            "left join g.fleaType t " +
            "left join g.fleaUser u " +
            "where g.pkFleaGoodsId = ?1 ")
    List<FleaGoodsVo> selectGoodsById(Long goodId);

    /**
     * 下架商品
     *
     * @param isDeleted Boolean
     * @param goodId    Long
     * @return int
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "update FleaGoods set isDeleted = ?1 where pkFleaGoodsId = ?2 ")
    int soldOutGood(Boolean isDeleted, Long goodId);
}
