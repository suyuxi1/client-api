package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.ThumbDto;
import com.niit.soft.client.api.domain.model.Thumb;
import com.niit.soft.client.api.repository.ThumbRepository;
import com.niit.soft.client.api.service.ThumbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yujie_Zhao
 * @ClassName ThumbServiceImpl
 * @Description 点赞service实现
 * @Date 2020/6/8  14:13
 * @Version 1.0
 **/
@Service
public class ThumbServiceImpl implements ThumbService {

    @Resource
    private ThumbRepository thumbRepository;

    @Override
    public ResponseResult insertThumb(ThumbDto thumbDto) {
        Thumb thumb = new Thumb();
        thumb.setIsDeleted(true);
        thumb.setDynamicId(Long.valueOf(thumbDto.getDynamicId()));
        thumb.setUserId(Long.valueOf(thumbDto.getUserId()));
        thumbRepository.save(thumb);
        return ResponseResult.success("添加成功");
    }

    @Override
    public ResponseResult deleteThumb(ThumbDto thumbDto) {
        thumbRepository.deleteByDynamicIdAndDynamicId(Long.valueOf(thumbDto.getDynamicId()), Long.valueOf(thumbDto.getUserId()));
        return ResponseResult.success("删除成功");
    }
}
