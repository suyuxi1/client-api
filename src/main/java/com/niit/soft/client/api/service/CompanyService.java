package com.niit.soft.client.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.Company;
import com.niit.soft.client.api.domain.vo.CompanyVo;

import java.util.List;

/**
 * @author Su
 * @className CompanyService
 * @Description TODO
 * @Date 2020/6/11 17:35
 * @Version 1.0
 **/
public interface CompanyService extends IService<Company> {

    List<Company> findByPage(PageDto pageDto);

    CompanyVo findById(Long id);
}
