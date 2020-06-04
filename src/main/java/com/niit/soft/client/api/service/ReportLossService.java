package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;

/**
 * @ClassName ReportLossService
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/1
 **/
public interface ReportLossService {
    /**
     * 分页查询挂失信息
     * @param pageDto
     * @return
     */
    ResponseResult findAllByPage(PageDto pageDto);
    /**
     * 校园卡挂失
     * @param pkReportLossId
     * @param lossStatus
     * @return
     */
    ResponseResult updateLossStatus(Long pkReportLossId,Boolean lossStatus);
}