package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.DynamicCollectionInDto;
import com.niit.soft.client.api.domain.dto.PageDto;

/**
 * @author Yujie_Zhao
 * @ClassName CollectionsService
 * @Description 收藏
 * @Date 2020/6/11  9:49
 * @Version 1.0
 **/
public interface CollectionsService {

    /**
     *分页查询所有咨询
     * @param pageDto
     *
     * @return PageDto pageDto
     */
    ResponseResult getCollectionsByUserId(PageDto pageDto);

    /**
     * 添加收藏
     * @param dynamicCollectionInDto
     * @return
     */
    ResponseResult insertCollections(DynamicCollectionInDto dynamicCollectionInDto);

    ResponseResult updateCollectionsIsDelete(Long id);
}
