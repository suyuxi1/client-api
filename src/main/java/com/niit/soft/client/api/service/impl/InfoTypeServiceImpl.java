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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Override
    public ResponseResult getAllType() {
        List<InfoType> infoTypeList = infoTypeRepository.findAll();
        return ResponseResult.success(infoTypeList);
    }

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
        List<InfoManage> mapList = new ArrayList<>();
        infoMangeTypes.forEach(infoType1 -> {
            if (infoType1.getTypeId().equals(id)){
                mapList.add(infoManageRepository.getInfoManageByPkInfoManageId(infoType1.getInfoId()));
                infoType.setInfoManageList(mapList);
            }
        });
        return ResponseResult.success(infoType);
    }

    /**
     * 根据资讯分类id查找对应所有资讯(正在测试、少访问一次数据库)
     * @param id
     * @return InfoType
     */
    @Override
    public ResponseResult getInfoByPkInfoTypeId(Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String,Object>> mapList = infoTypeRepository.findInfoByPkInfoTypeId(id);
        map.put("name", (String) mapList.get(0).get("name"));
        map.put("pk_info_manage_id", (String) mapList.get(0).get("pk_info_manage_id"));
        List<InfoManage> infoManageList = new ArrayList<>();
        mapList.forEach(mapList1 -> {
            infoManageList.add(infoManageRepository.getInfoManageByPkInfoManageId(Long.parseLong(mapList1.get("pk_info_manage_id").toString())));
        });
        map.put("infoManageList",infoManageList);

        return ResponseResult.success(map);
    }
}
