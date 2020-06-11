package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.DynamicDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.dto.ThumbDto;
import com.niit.soft.client.api.domain.model.Dynamic;
import com.niit.soft.client.api.domain.vo.CommentVo;
import com.niit.soft.client.api.domain.vo.DynamicVo;

import java.util.List;

/**
 * @ClassName DynamicService
 * @Description 好友圈模块动态资讯
 * @Author xiaobinggan
 * @Date 2020/6/8 8:10 下午
 * @Version 1.0
 **/
public interface DynamicService {
    /**
     * 根据id查找动态资讯
     *
     * @param id
     * @return
     */
    DynamicVo findDynamicVoById(int id);


    /**
     * 查找所有资讯
     *
     * @param pageDto
     * @return
     */
    List<Dynamic> findDynamicByPage(PageDto pageDto);

    /**
     * 删除动态
     *
     * @param dynamic
     * @return
     */
    int deleteDynamicById(Dynamic dynamic);


    /**
     * 根据id查找多层级评论
     *
     * @param id
     * @return
     */
    CommentVo findCommentVoById(Long id);

    /**
     * 添加新的动态
     *
     * @param dynamicDto
     */
    Dynamic addOne(DynamicDto dynamicDto);

    /**
     * 点赞
     *
     * @param thumbDto
     */
    ResponseResult thumbsUp(ThumbDto thumbDto);

}