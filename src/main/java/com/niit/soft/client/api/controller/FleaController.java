package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.FleaGoodsDto;
import com.niit.soft.client.api.domain.dto.PageDto;
import com.niit.soft.client.api.repository.FleaTypeRepository;
import com.niit.soft.client.api.service.FleaGoodsService;
import com.niit.soft.client.api.service.FleaRewardService;
import com.niit.soft.client.api.service.FleaTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private FleaRewardService fleaRewardService;
    @Resource
    private FleaGoodsService fleaGoodsService;
    @Resource
    private FleaTypeService fleaTypeService;

    @ControllerWebLog(name = "getTopTwoReward",isSaved = true)
    @ApiOperation(value = "查询悬赏最新的前两条数据",notes = "不需要参数")
    @PostMapping("/reward/top")
    public ResponseResult getTopTwoReward(){
        log.info("进入查询悬赏数据接口");
        return fleaRewardService.getRewardTopTwo();
    }

    @ControllerWebLog(name = "getGoodsByTime",isSaved = true)
    @ApiOperation(value = "查询商品信息，根据时间排序",notes = "pageDto分页参数，参数从0页开始")
    @PostMapping("/goods/all")
    public ResponseResult getGoodsByTime(@RequestBody PageDto pageDto){
        log.info("进入查询商品信息接口，传来的分页参数为: pageDto",pageDto+"**1**");
        return fleaGoodsService.getGoodsByTime(pageDto);
    }

    @ControllerWebLog(name = "getGoodsByType",isSaved = true)
    @ApiOperation(value = "根据类别ID查询商品信息",notes = "pageDto分页参数和typeId类别ID，参数从0页开始")
    @PostMapping("/goods/type")
    public ResponseResult getGoodsByType(@RequestBody PageDto pageDto, @RequestParam("typeId") Long typeId){
        log.info("进入根据类型查询商品接口，传来的参数为：pageDtp,typeId",pageDto,typeId+"**1**");
        return fleaTypeService.getGoodsByType(pageDto,typeId);
    }

    @ControllerWebLog(name = "findGoodById", isSaved = true)
    @ApiOperation(value = "根据商品id查询指定商品的详细信息", notes = "请求参数为商品id----goodId   ")
    @PostMapping(value = "goods/id")
    public ResponseResult findGoodById(@RequestParam Long goodId) {
        log.info("访问goods/id接口");
        log.info("-----goods/id-----请求参数：" + goodId + "**1**");
        return fleaGoodsService.findGoodById(goodId);
    }

    @ControllerWebLog(name = "updateGoodMessage", isSaved = true)
    @ApiOperation(value = "修改商品信息", notes = "请求参数为商品类、发布人id、类型id----fleaGoods、userId、typeId  ")
    @PutMapping(value = "goods/set")
    public ResponseResult updateGoodMessage(@RequestBody FleaGoodsDto fleaGoodsDto) {
        log.info("访问goods/set接口");
        log.info("-----goods/set-----请求参数：" + fleaGoodsDto + "**1**");
        return fleaGoodsService.updateGood(fleaGoodsDto);
    }

    @ControllerWebLog(name = "updateGoodMessage", isSaved = true)
    @ApiOperation(value = "下架商品", notes = "请求参数为删除标志、商品id----isDeleted、goodId  ")
    @PutMapping(value = "goods/delete")
    public ResponseResult soldOutGood(@RequestParam Boolean isDeleted, @RequestParam Long goodId) {
        log.info("访问goods/delete接口");
        log.info("-----goods/delete-----请求参数：" + isDeleted + "-----" + goodId + "**1**");
        return fleaGoodsService.soldOutGood(isDeleted, goodId);
    }
}
