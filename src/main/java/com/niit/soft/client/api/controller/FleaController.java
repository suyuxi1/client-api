package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.FleaSearchDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.domain.model.FleaGoods;
import com.niit.soft.client.api.domain.model.FleaReward;
import com.niit.soft.client.api.domain.model.FleaType;
import com.niit.soft.client.api.service.FleaGoodsService;
import com.niit.soft.client.api.service.FleaRewardService;
import com.niit.soft.client.api.service.FleaTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaController.java
 * @Description TODO
 * @createTime 2020年06月09日 14:37:00
 */
@Slf4j
@RestController
@RequestMapping(value = "/flea/")
@Api(value = "FleaController", tags = {"跳蚤市场接口"})
public class FleaController {
    @Resource
    private FleaGoodsService fleaGoodsService;
    @Resource
    private FleaRewardService fleaRewardService;
    @Resource
    private FleaTypeService fleaTypeService;

    /**
     * 根据搜索框的输入模糊查询  商品名，标签，或 悬赏
     */
    @ApiOperation(value = "模糊搜索", notes = "根据搜索框的输入模糊查询  商品名，标签，或 悬赏")
    @PostMapping("search")
    @ControllerWebLog(name = "searchByContent", isSaved = true)
    ResponseResult searchByContent(@RequestBody FleaSearchDto fleaSearchDto) {
        log.info("-----searchByContent-----请求参数：" + fleaSearchDto+"**1**");
        Map<String, Object> map = new HashMap<String, Object>();
        //查询符合的商品
        final Page<FleaGoods> fleaGoodsByContent = fleaGoodsService.findFleaGoodsByContent(fleaSearchDto);
        //查询符合的悬赏
        final Page<FleaReward> fleaRewardByContent = fleaRewardService.findFleaRewardByContent(fleaSearchDto);
        map.put("fleaGoods", fleaGoodsByContent);
        map.put("fleaReward", fleaRewardByContent);
        return ResponseResult.success(map);
    }

    /**
     * 查找所有分类
     *
     * @return
     */
    @ApiOperation(value = "查询所有分类", notes = "分为一级分类和二级分类")
    @PostMapping("type/all")
    @ControllerWebLog(name="findAllType",isSaved = true)
    ResponseResult findAllType() {
        return ResponseResult.success(fleaTypeService.findAllType());
    }

    /**
     * 查找所有悬赏
     *
     * @return
     */
    @ApiOperation(value = "查询所有悬赏", notes = "返回所有的悬赏")
    @PostMapping("reward/all")
    @ControllerWebLog(name = "findRewardType", isSaved = true)
    ResponseResult findRewardType(@RequestBody PageDto pageDto) {
        log.info("-----findRewardType-----请求参数：" + pageDto+"**1**");
        return ResponseResult.success(fleaRewardService.findAll(pageDto));
    }


}
