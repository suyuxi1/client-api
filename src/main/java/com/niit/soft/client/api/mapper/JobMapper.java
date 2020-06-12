package com.niit.soft.client.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.Job;
import com.niit.soft.client.api.domain.vo.JobVo;

import java.util.List;

/**
 * @author Su
 * @className JobMapper
 * @Description TODO
 * @Date 2020/6/11 15:44
 * @Version 1.0
 **/
public interface JobMapper extends BaseMapper<Job> {

    JobVo findJob(Long id);


    List<JobVo> jobList(String field);
}
