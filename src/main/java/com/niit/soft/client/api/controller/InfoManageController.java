package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.service.InfoManageService;
import com.niit.soft.client.api.service.InfoTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Yujie_Zhao
 * @ClassName InfoManageController
 * @Description 资讯模块Controller层
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
     * 查找所有资讯
     * @return List<InfoManage>
     */
    @ControllerWebLog(name = "getAllInfo", isSaved = true)
    @ApiOperation(value = "查找所有资讯",notes = "")
    @GetMapping(value = "/all")
    public ResponseResult getAllInfo(){
        return infoManageService.getAllInfo();
    }

    /**
     * 分页查找所有资讯
     * @return List<InfoManage>
     */
    @ControllerWebLog(name = "findAllInfoByPage", isSaved = true)
    @ApiOperation(value = "分页查找所有资讯",notes = "请求参数为当前页和页面条数，不包含置顶咨询")
    @PostMapping(value = "/allInfo")
    public ResponseResult findAllInfoByPage(@RequestBody PageDto pageDto){
        return infoManageService.findAllInfoByPage(pageDto);
    }

    /**
     * 查询置顶资讯
     * @return  List<InfoManage>
     */
    @ControllerWebLog(name = "getIsTopInfo", isSaved = true)
    @ApiOperation(value = "查询置顶资讯",notes = "")
    @GetMapping(value = "/isTap")
    public ResponseResult getIsTopInfo(){
        return infoManageService.getIsTopInfo();
    }

    /**
     * 资讯所有分类查询
     * @return InfoType
     */
    @ControllerWebLog(name = "getInfoAllType", isSaved = true)
    @ApiOperation(value = "查询所有分类",notes = "")
    @GetMapping(value = "/type/all")
    public ResponseResult getInfoAllType(){
        return infoTypeService.getAllType();
    }

    /**
     * 资讯分类查询
     * @param id
     * @return InfoType
     */
    @ControllerWebLog(name = "getInfoByType", isSaved = true)
    @ApiOperation(value = "查询资讯分类",notes = "更具资讯分类id获取分类信息")
    @GetMapping(value = "/type")
    public ResponseResult getInfoByType(Long id){
        log.info("-----/type-----请求参数：" + id+"**1**");
        return infoTypeService.getInfoByType(id);
    }
}
