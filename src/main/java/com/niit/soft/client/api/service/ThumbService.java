package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.ThumbDto;

/**
 * @author Yujie_Zhao
 * @ClassName ThumbService
 * @Description 校友动态点赞
 * @Date 2020/6/8  14:13
 * @Version 1.0
 **/
public interface ThumbService {
    /**
     * 增添点赞
     * @param thumbDto
     * @return
     */
    ResponseResult insertThumb(ThumbDto thumbDto);


    /**
     * 删除点赞
     * @param thumbDto
     * @return
     */
    ResponseResult deleteThumb(ThumbDto thumbDto);

}
