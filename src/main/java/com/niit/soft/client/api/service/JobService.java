package com.niit.soft.client.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.PartJob;
import com.niit.soft.client.api.domain.vo.PartJobVo;

import java.util.List;

/**
 * @author Su
 * @className JobService
 * @Description TODO
 * @Date 2020/6/9 14:15
 * @Version 1.0
 **/
public interface JobService extends IService<PartJob> {

    /**
     * 分页查询兼职信息,按照传递的参数排列
     * @param pageDto
     * @return
     */
    List<PartJob> findAllByPage(PageDto pageDto);

    /**
     * 添加兼职
     * @param partJob
     * @return
     */
    int insertJob(PartJob partJob);

}
