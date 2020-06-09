package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.repository.FleaGoodsRepository;
import com.niit.soft.client.api.service.FleaGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<FleaGoodsService> findFileGoodsByContent(String content) {
        return null;
    }

    @Override
    public ResponseResult getGoodsByTime(PageDto pageDto) {
        Pageable pageable = PageRequest.of(pageDto.getCurrentPage(),pageDto.getPageSize(), Sort.Direction.DESC,"goodsCreateTime");
        if (fleaGoodsRepository.getAllGoodsByTime(pageable).size() == 0){
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(fleaGoodsRepository.getAllGoodsByTime(pageable));

    }
}
