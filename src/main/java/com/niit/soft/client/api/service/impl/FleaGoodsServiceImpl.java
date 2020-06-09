package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.domain.dto.FleaSearchDto;
import com.niit.soft.client.api.domain.model.FleaGoods;
import com.niit.soft.client.api.repository.FleaGoodsRepository;
import com.niit.soft.client.api.service.FleaGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.domain.dto.FleaGoodsDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.FleaGoods;
import com.niit.soft.client.api.domain.model.FleaType;
import com.niit.soft.client.api.domain.model.FleaUser;
import com.niit.soft.client.api.repository.FleaGoodsRepository;
import com.niit.soft.client.api.repository.FleaTypeRepository;
import com.niit.soft.client.api.repository.FleaUserRepository;
import com.niit.soft.client.api.service.FleaGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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
    @Resource
    private FleaUserRepository fleaUserRepository;
    @Resource
    private FleaTypeRepository fleaTypeRepository;

    @Override
    public Page<FleaGoods> findFleaGoodsByContent(FleaSearchDto fleaSearchDto) {
        //创建分页构建器   按照时间降序排序
        Pageable pageable = PageRequest.of(fleaSearchDto.getCurrentPage(), fleaSearchDto.getPageSize(), Sort.Direction.DESC, "goodsCreateTime");
        //根据内容模糊搜索
        List<FleaGoods> result = fleaGoodsRepository.findFleaGoodsByGoodsNameLikeOrGoodsDescriptionLike("%"+fleaSearchDto.getContent()+"%", "%"+fleaSearchDto.getContent()+"%");
        Page<FleaGoods> fleaGoodsInfo = new PageImpl<FleaGoods>(result, pageable, result.size());
        return fleaGoodsInfo;
    }


    @Override
    public ResponseResult getGoodsByTime(PageDto pageDto) {
        Pageable pageable = PageRequest.of(pageDto.getCurrentPage(),pageDto.getPageSize(), Sort.Direction.DESC,"goodsCreateTime");
        if (fleaGoodsRepository.getAllGoodsByTime(pageable).size() == 0){
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(fleaGoodsRepository.getAllGoodsByTime(pageable));

    }

    @Override
    public ResponseResult findGoodById(Long id) {
        return ResponseResult.success(fleaGoodsRepository.selectGoodsById(id));
    }

    @Override
    public ResponseResult updateGood(FleaGoodsDto fleaGoodsDto) {
        Optional<FleaGoods> fleaGoodsList = fleaGoodsRepository.findById(fleaGoodsDto.getPkFleaGoodsId());
        Optional<FleaUser> fleaUserList = fleaUserRepository.findById(fleaGoodsDto.getPkFleaUserId());
        Optional<FleaType> fleaTypeList = fleaTypeRepository.findById(fleaGoodsDto.getPkFleaTypeId());
        FleaUser fleaUser = FleaUser.builder()
                .pkFleaUserId(fleaUserList.get().getPkFleaUserId())
                .avatar(fleaUserList.get().getAvatar()).jobNumber(fleaUserList.get().getJobNumber())
                .nickname(fleaUserList.get().getNickname()).phoneNumber(fleaUserList.get().getPhoneNumber())
                .sex(fleaUserList.get().getSex()).username(fleaUserList.get().getUsername())
                .build();
        FleaType fleaType = FleaType.builder()
                .parentId(fleaTypeList.get().getParentId()).pkFleaTypeId(fleaTypeList.get().getPkFleaTypeId())
                .typeCoverUrl(fleaTypeList.get().getTypeCoverUrl()).typeName(fleaTypeList.get().getTypeName())
                .typeUrl(fleaTypeList.get().getTypeUrl())
                .build();
        FleaGoods fleaGoods1 = FleaGoods.builder()
                .pkFleaGoodsId(fleaGoodsDto.getPkFleaGoodsId()).goodsName(fleaGoodsDto.getGoodsName())
                .goodsDescription(fleaGoodsDto.getGoodsDescription()).goodsImgUrl(fleaGoodsDto.getGoodsImgUrl())
                .goodsPrice(fleaGoodsDto.getGoodsPrice()).goodsCreateTime(fleaGoodsList.get().getGoodsCreateTime())
                .fleaType(fleaType).fleaUser(fleaUser).goodsMark(fleaGoodsDto.getGoodsMark())
                .build();
        return ResponseResult.success(fleaGoodsRepository.saveAndFlush(fleaGoods1));
    }

    @Override
    public ResponseResult soldOutGood(Boolean isDeleted, Long goodId) {
        return ResponseResult.success(fleaGoodsRepository.soldOutGood(isDeleted, goodId));
    }
}
