package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.CollectionDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.Collections;
import com.niit.soft.client.api.mapper.CollectionsMapper;
import com.niit.soft.client.api.repository.CollectionsRepository;
import com.niit.soft.client.api.repository.DynamicPhotoRepository;
import com.niit.soft.client.api.service.CollectionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName CollectionsServiceImpl
 * @Description 收藏
 * @Date 2020/6/11  9:49
 * @Version 1.0
 **/
@Service
public class CollectionsServiceImpl implements CollectionsService {
    @Resource
    private CollectionsMapper collectionsMapper;

    @Resource
    private CollectionsRepository collectionsRepository;

    @Resource
    private DynamicPhotoRepository dynamicPhotoRepository;
    @Override
    public ResponseResult findCollections(Long id) {
        collectionsMapper.findCollectionsByUserId(id);
        return null;
    }

    @Override
    public ResponseResult getCollectionsByUserId(PageDto pageDto) {
        List<CollectionDto> collectionDtoArrayList = new ArrayList<>();

        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pk_collection_id");
        Page<Collections> collectionsPage =
                collectionsRepository.getCollectionsByUserId(Long.parseLong((String) pageDto.getField()),pageable);
        collectionsPage.forEach(collections -> {
            CollectionDto collectionDto = collectionsMapper.findCollectionsByDynamicId(collections.getDynamicId());
            //得到一个资讯的所有配图
            List<String> dynamicPhotoList = dynamicPhotoRepository.findDistinctByDynamicId(collections.getDynamicId());
            if (dynamicPhotoList != null){
                collectionDto.setPicture(dynamicPhotoList);
            }
            collectionDtoArrayList.add(collectionDto);
        });
        return ResponseResult.success(collectionDtoArrayList);
    }
}
