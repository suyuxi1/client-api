package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.model.InfoManage;
import com.niit.soft.client.api.domain.model.InfoMangeType;
import com.niit.soft.client.api.domain.model.InfoType;
import com.niit.soft.client.api.repository.InfoManageRepository;
import com.niit.soft.client.api.repository.InfoMangeTypeRepository;
import com.niit.soft.client.api.repository.InfoTypeRepository;
import com.niit.soft.client.api.service.InfoTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName InfoTypeServiceImpl
 * @Description 资讯分类Service实现类
 * @Date 2020/5/26  22:05
 * @Version 1.0
 **/
@Service
public class InfoTypeServiceImpl implements InfoTypeService {

    @Resource
    private InfoTypeRepository infoTypeRepository;
    @Resource
    private InfoMangeTypeRepository infoMangeTypeRepository;
    @Resource
    private InfoManageRepository infoManageRepository;


    /**
     * 根据资讯分类id查找对应所有资讯
     * @param id
     * @return InfoType
     */
    @Override
    public ResponseResult getInfoByType(Long id) {
        InfoType infoType = infoTypeRepository.findByPkInfoTypeId(id);
        List<InfoMangeType> infoMangeTypes = infoMangeTypeRepository.findAll();
        //循环所有的资讯分类关联信息，根据分类id找到对应资讯，放入资讯分类中
        infoMangeTypes.forEach(infoType1 -> {
            if (infoType1.getTypeId().equals(id)){
                List<InfoManage> mapList =infoManageRepository.getInfoByType(infoType1.getInfoId());
                infoType.setInfoManageList(mapList);
            }
        });
        return ResponseResult.success(infoType);
    }
}
