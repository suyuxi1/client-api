package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.FleaType;
import com.niit.soft.client.api.repository.FleaTypeRepository;
import com.niit.soft.client.api.service.FleaGoodsService;
import com.niit.soft.client.api.service.FleaTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaTypeServiceImpl.java
 * @Description TODO
 * @createTime 2020年06月09日 14:06:00
 */
@Slf4j
@Service
public class FleaTypeServiceImpl implements FleaTypeService {
    @Resource
    private FleaTypeRepository fleaTypeRepository;
    @Override
    public ResponseResult getGoodsByType(PageDto pageDto, Long typeId) {
        Pageable pageable = PageRequest.of(pageDto.getCurrentPage(),pageDto.getPageSize(), Sort.Direction.DESC,"goodsCreateTime");
        if (fleaTypeRepository.getGoodsByTypeId(pageable,typeId).size() == 0){
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(fleaTypeRepository.getGoodsByTypeId(pageable,typeId));
    }
}
