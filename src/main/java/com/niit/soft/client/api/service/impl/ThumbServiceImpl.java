package com.niit.soft.client.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.soft.client.api.domain.model.Thumb;
import com.niit.soft.client.api.mapper.ThumbMapper;
import com.niit.soft.client.api.service.ThumbService;
import org.springframework.stereotype.Service;

/**
 * @author Yujie_Zhao
 * @ClassName ThumbServiceImpl
 * @Description 点赞service实现
 * @Date 2020/6/8  14:13
 * @Version 1.0
 **/
@Service
public class ThumbServiceImpl extends ServiceImpl<ThumbMapper, Thumb> implements ThumbService {

}
