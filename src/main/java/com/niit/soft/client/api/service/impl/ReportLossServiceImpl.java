package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.ReportLoss;
import com.niit.soft.client.api.repository.ReportLossRepository;
import com.niit.soft.client.api.service.ReportLossService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName ReportServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/1
 **/
@Service
public class ReportLossServiceImpl implements ReportLossService {
    @Resource
    private ReportLossRepository reportLossRepository;

    /**
     * 分页查询所有信息
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult findAllByPage(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage()-1,
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkReportLossId");
        Page<ReportLoss> reportLosses = reportLossRepository.findAll(pageable);
        return ResponseResult.success(reportLosses.getContent());
    }
}