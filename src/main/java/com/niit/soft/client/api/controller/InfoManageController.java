package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.service.InfoManageService;
import com.niit.soft.client.api.service.InfoTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
@Api(value = "InfoManageController",tags = {"资讯接口"})
public class InfoManageController {
    @Resource
    private InfoManageService infoManageService;

    @Resource
    private InfoTypeService infoTypeService;

    /**
     * 查找所有资讯1
     * @return List<InfoManage>
     */
    @ApiOperation(value = "查找所有资讯",notes = "")
    @GetMapping(value = "/all")
    @ControllerWebLog(name = "getAllInfo",isSaved = true)
    public ResponseResult getAllInfo(){
        return infoManageService.getAllInfo();
    }

    /**
     * 查询置顶资讯
     * @return  List<InfoManage>
     */
    @ApiOperation(value = "查询置顶资讯",notes = "")
    @GetMapping(value = "/isTap")
    @ControllerWebLog(name = "getIsTopInfo",isSaved = true)
    public ResponseResult getIsTopInfo(){
        return infoManageService.getIsTopInfo();
    }

    /**
     * 资讯分类查询
     * @param id
     * @return InfoType
     */
    @ControllerWebLog(name = "getInfoByType",isSaved = true)
    @ApiOperation(value = "查询资讯分类",notes = "")
    @GetMapping(value = "/type")
    public ResponseResult getInfoByType(Long id){
        return infoTypeService.getInfoByType(id);
    }
}
