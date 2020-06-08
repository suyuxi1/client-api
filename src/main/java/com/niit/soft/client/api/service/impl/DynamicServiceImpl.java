package com.niit.soft.client.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.Dynamic;
import com.niit.soft.client.api.domain.vo.CommentVo;
import com.niit.soft.client.api.domain.vo.DynamicVo;
import com.niit.soft.client.api.mapper.CommentMapper;
import com.niit.soft.client.api.mapper.DynamicMapper;
import com.niit.soft.client.api.service.DynamicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @ClassName DynamicServiceImpl
 * @Description 好友圈模块动态资讯
 * @Author xiaobinggan
 * @Date 2020/6/8 8:10 下午
 * @Version 1.0
 **/
@Service
@Transactional
public class DynamicServiceImpl implements DynamicService {
    @Resource
    private DynamicMapper dynamicMapper;
    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<DynamicVo> findDynamicVoById(Long id) {
        return dynamicMapper.findDynamicVoById(id);
    }

    @Override
    public List<Dynamic> findDynamicByPage(PageDto pageDto) {
        return dynamicMapper.selectPage(new Page(pageDto.getCurrentPage(), pageDto.getPageSize()),
                new QueryWrapper<>()).getRecords();
    }

    @Override
    public int addOne(Dynamic dynamic) {
        return dynamicMapper.insert(dynamic);
    }

    @Override
    public List<CommentVo> findCommentVoById(Long id) {
        return commentMapper.findCommentVoById(id);
    }

    @Override
    public int deleteDynamicById(Dynamic dynamic) {
        UpdateWrapper<Dynamic> wrapper = new UpdateWrapper<>();
        wrapper.set("is_deleted", 0);
        return dynamicMapper.update(dynamic, wrapper);
    }


}
