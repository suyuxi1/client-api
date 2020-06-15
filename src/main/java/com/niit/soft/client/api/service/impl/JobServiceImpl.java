package com.niit.soft.client.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.Job;
import com.niit.soft.client.api.domain.vo.JobVo;
import com.niit.soft.client.api.mapper.JobMapper;
import com.niit.soft.client.api.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author su
 * @className JobService
 * @Description TODO
 * @Date 2020/6/11
 * @Version 1.0
 **/
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

    @Resource
    private JobMapper jobMapper;

    @Override
    public List<JobVo> find(PageDto pageDto) {
        return jobMapper.jobList(pageDto.getField().toString());
    }

    @Override
    public JobVo findById(Long id) {
        return jobMapper.findJob(id);
    }
}
