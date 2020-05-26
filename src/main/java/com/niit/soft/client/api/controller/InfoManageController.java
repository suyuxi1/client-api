package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.domain.model.InfoManage;
import com.niit.soft.client.api.service.InfoManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName InfoManageController
 * @Description TODO
 * @Date 2020/5/26  11:52
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/info")
public class InfoManageController {
    @Resource
    private InfoManageService infoManageService;

    @GetMapping(value = "/all")
    public List<InfoManage>getAllInfo(){
        return infoManageService.getAllInfo();
    }

    @GetMapping(value = "/isTap")
    public List<InfoManage>getIsTopInfo(){
        return infoManageService.getIsTopInfo();
    }
}
