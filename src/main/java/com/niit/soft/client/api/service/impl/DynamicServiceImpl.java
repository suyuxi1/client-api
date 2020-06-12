package com.niit.soft.client.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.common.ResultCode;
import com.niit.soft.client.api.domain.dto.DynamicDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.dto.ThumbDto;
import com.niit.soft.client.api.domain.model.Comment;
import com.niit.soft.client.api.domain.model.Dynamic;
import com.niit.soft.client.api.domain.model.Thumb;
import com.niit.soft.client.api.domain.vo.CommentVo;
import com.niit.soft.client.api.domain.vo.DynamicVo;
import com.niit.soft.client.api.mapper.CommentMapper;
import com.niit.soft.client.api.mapper.DynamicMapper;
import com.niit.soft.client.api.mapper.ThumbMapper;
import com.niit.soft.client.api.repository.DynamicRepository;
import com.niit.soft.client.api.service.DynamicService;
import com.niit.soft.client.api.util.RedisUtil;
import com.niit.soft.client.api.util.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @ClassName DynamicServiceImpl
 * @Description 好友圈模块动态资讯
 * @Author xiaobinggan
 * @Date 2020/6/8 8:10 下午
 * @Version 1.0
 **/
@Service
@Transactional
@Slf4j
public class DynamicServiceImpl implements DynamicService {
    @Resource
    private DynamicMapper dynamicMapper;
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ThumbMapper thumbMapper;
    @Resource
    private DynamicRepository dynamicRepository;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public DynamicVo findDynamicVoById(String id) {
        //
        DynamicVo dynamicVo = dynamicMapper.findDynamicVoById(Long.valueOf(id));

        List<Comment> commentList = dynamicVo.getCommentList();
        List<CommentVo> commentVoList = new ArrayList<>();
        if (commentList.get(0).getPkCommentId() != null) {
            for (Comment comment : commentList) {
                commentVoList.add(commentMapper.findCommentVoById(comment.getPkCommentId()));
            }
            dynamicVo.setCommentVoList(commentVoList);
        } else {
            dynamicVo.setCommentList(null);
        }


        Map<String, Object> thumbMap = new HashMap<>(10);
        List<Thumb> thumbList = dynamicVo.getThumbList();
        if (thumbList.get(0).getPkThumbId() != null) {
            for (Thumb thumb : thumbList) {
                thumbMap.put(thumb.getPkThumbId().toString(), thumb.getUserId().toString());
            }
            // 将动态资讯的id存为键，将点赞id和用户id存为map
            boolean hmset = redisUtil.hmset(id, thumbMap);
            if (hmset) {
                log.info("成功存入redis");
            }
        } else {
            dynamicVo.setThumbList(null);
        }

        return dynamicVo;
    }

    @Override
    public ResponseResult thumbsUp(ThumbDto thumbDto) {
        Map<Object, Object> map = redisUtil.hmget(thumbDto.getDynamicId());
        Boolean flag = false;
        if (redisUtil.hasKey(thumbDto.getDynamicId())) {
            for (Entry<Object, Object> entry : map.entrySet()) {
                System.out.println("foreachEntry : key :" + entry.getKey() + "---> value :" + entry.getValue());
                if (entry.getKey().equals(thumbDto.getPkThumbId()) || entry.getValue().equals(thumbDto.getUserId())) {
                    flag = false;
                    log.info("从redis删除");
                    redisUtil.hdel(thumbDto.getDynamicId(), thumbDto.getPkThumbId(), thumbDto.getUserId());
                    return ResponseResult.failure(ResultCode.SCHOOL_MATE_THUMBS_DOWN);
                }
                flag = true;
            }
            if (flag) {
                log.info("存redis");
                Map<String, Object> thumbMap = new HashMap<>(10);
                thumbMap.put(String.valueOf(new SnowFlake(1, 3).nextId()), thumbDto.getUserId());
                redisUtil.hmset(thumbDto.getDynamicId(), thumbMap);
            }

        } else {
            return ResponseResult.success(ResultCode.SCHOOL_MATE_THUMBS_UP_REDIS);
        }
        return ResponseResult.success(ResultCode.SCHOOL_MATE_THUMBS_UP);
    }


    @Override
    public List<Dynamic> findDynamicByPage(PageDto pageDto) {
        return dynamicMapper.selectPage(new Page(pageDto.getCurrentPage(), pageDto.getPageSize()),
                new QueryWrapper<>()).getRecords();
    }

    @Override
    public Dynamic addOne(DynamicDto dynamicDto) {
        return dynamicRepository.save(Dynamic.builder()
                .pkDynamicId(new SnowFlake(1, 3).nextId())
                .title(dynamicDto.getTitle())
                .content(dynamicDto.getContent())
                .type(dynamicDto.getType())
                .comments(0)
                .thumbs(0)
                .userId(dynamicDto.getUserId())
                .isDeleted(false).build());
    }

    @Override
    public CommentVo findCommentVoById(Long id) {
        return commentMapper.findCommentVoById(id);
    }

    @Override
    public int deleteDynamicById(Dynamic dynamic) {
        UpdateWrapper<Dynamic> wrapper = new UpdateWrapper<>();
        wrapper.set("is_deleted", 0);
        return dynamicMapper.update(dynamic, wrapper);
    }
}
