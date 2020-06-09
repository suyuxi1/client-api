package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.domain.dto.FleaSearchDto;
import com.niit.soft.client.api.domain.model.FleaGoods;
import com.niit.soft.client.api.repository.FleaGoodsRepository;
import com.niit.soft.client.api.service.FleaGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsServiceImpl.java
 * @Description TODO
 * @createTime 2020年06月09日 14:06:00
 */
@Slf4j
@Service
public class FleaGoodsServiceImpl implements FleaGoodsService {
    @Resource
    private FleaGoodsRepository fleaGoodsRepository;

    @Override
    public Page<FleaGoods> findFleaGoodsByContent(FleaSearchDto fleaSearchDto) {
        //创建分页构建器   按照时间降序排序
        Pageable pageable = PageRequest.of(fleaSearchDto.getCurrentPage(), fleaSearchDto.getPageSize(), Sort.Direction.DESC, "goodsCreateTime");
        //根据内容模糊搜索
        List<FleaGoods> result = fleaGoodsRepository.findFleaGoodsByGoodsNameLikeOrGoodsDescriptionLike("%"+fleaSearchDto.getContent()+"%", "%"+fleaSearchDto.getContent()+"%");
        Page<FleaGoods> fleaGoodsInfo = new PageImpl<FleaGoods>(result, pageable, result.size());
        return fleaGoodsInfo;
    }
}
