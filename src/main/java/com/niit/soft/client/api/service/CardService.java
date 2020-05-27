package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.SysCard;

import java.util.List;

/**
 * @ClassName CardService
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/26
 **/
public interface CardService {
    /**
     * 分页查询一卡通数据
     * @param pageDto
     * @return
     */
    ResponseResult findAllByPage(PageDto pageDto);

    /**
     * 批量增加一卡通信息
     * @return
     * @param sysCards
     */
    ResponseResult insertAll(List<SysCard> sysCards);
}