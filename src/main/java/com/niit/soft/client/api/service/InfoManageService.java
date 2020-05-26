package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.model.InfoManage;

import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName InfoManageService
 * @Description 资讯Service
 * @Date 2020/5/26  11:39
 * @Version 1.0
 **/
public interface InfoManageService {
    /**
     * 查询所有咨讯
     * @return
     */
    List<InfoManage> getAllInfo();

    /**
     *  查询置顶资讯
     * @return
     */
    List<InfoManage> getIsTopInfo();
}
