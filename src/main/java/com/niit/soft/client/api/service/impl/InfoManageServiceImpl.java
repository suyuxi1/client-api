package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.repository.InfoManageRepository;
import com.niit.soft.client.api.domain.model.InfoManage;
import com.niit.soft.client.api.service.InfoManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName InfoManageServiceImpl
 * @Description TODO
 * @Date 2020/5/26  11:41
 * @Version 1.0
 **/
@Service
public class InfoManageServiceImpl implements InfoManageService {

    @Resource
    private InfoManageRepository infoManageRepository;

    /**
     * 查询全部资讯
     * @return List<InfoManage>
     */
    @Override
    public List<InfoManage> getAllInfo() {
        return infoManageRepository.findAll();
    }

    /**
     * 查询置顶资讯
     * @return List<InfoManage>
     */
    @Override
    public List<InfoManage> getIsTopInfo() {
        return infoManageRepository.getIsTopInfo();
    }
}
