package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
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
     * 根据用户id查找所有收藏动态
     * @param id
     * @return
     */
    ResponseResult findCollections(Long id);

    /**
     *分页查询所有咨询
     * @param pageDto
     *
     * @return PageDto pageDto
     */
    ResponseResult getCollectionsByUserId(PageDto pageDto);

}
