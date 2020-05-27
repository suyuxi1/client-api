package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.domain.model.InfoManage;
import com.niit.soft.client.api.domain.model.InfoType;
import com.niit.soft.client.api.service.InfoManageService;
import com.niit.soft.client.api.service.InfoTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName InfoManageController
 * @Description 资讯Controller层
 * @Date 2020/5/26  11:52
 * @Version 1.0
 **/

@RestController
@Slf4j
@RequestMapping(value = "/info")
public class InfoManageController {
    @Resource
    private InfoManageService infoManageService;

    @Resource
    private InfoTypeService infoTypeService;

    /**
     * 查找所有资讯
     * @return List<InfoManage>
     */
    @GetMapping(value = "/all")
    public List<InfoManage> getAllInfo(){
        return infoManageService.getAllInfo();
    }

    /**
     * 查询置顶资讯
     * @return  List<InfoManage>
     */
    @GetMapping(value = "/isTap")
    public List<InfoManage> getIsTopInfo(){
        return infoManageService.getIsTopInfo();
    }

    /**
     * 资讯分类查询
     * @param id
     * @return InfoType
     */
    @GetMapping(value = "/type")
    public InfoType getInfoByType(Long id){
        return infoTypeService.getInfoByType(id);
    }
}
