package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.annotation.ControllerWebLog;
import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.*;
import com.niit.soft.client.api.service.CollectionsService;
import com.niit.soft.client.api.service.CommentService;
import com.niit.soft.client.api.service.DynamicService;
import com.niit.soft.client.api.service.ReplyCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @ClassName DynamicController
 * @Description 好友圈模块动态资讯
 * @Author xiaobinggan
 * @Date 2020/6/8 8:14 下午
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/dynamic")
@Api(tags = "校友圈的接口")
public class DynamicController {
    @Resource
    private DynamicService dynamicService;

    @Resource
    private CommentService commentService;

    @Resource
    private ReplyCommentService replyCommentService;

    @Resource
    private CollectionsService collectionsService;

    @PostMapping("/{id}")
    @ControllerWebLog(name = "findDynamicVoById", isSaved = true)
    @ApiOperation(value = "好友圈根据id查找动态资讯", notes = "请求参数为动态id")
    ResponseResult findDynamicVoById(@PathVariable String id) {
        return ResponseResult.success(dynamicService.findDynamicVoById(id));
    }

    @PostMapping("/thumbsup")
    @ControllerWebLog(name = "thumbsUp", isSaved = true)
    @ApiOperation(value = "点赞", notes = "请求参数为thumbDto 再次点击为取消点赞")
    ResponseResult thumbsUp(@RequestBody ThumbDto thumbDto) {
        return dynamicService.thumbsUp(thumbDto);
    }


    @PostMapping
    @ControllerWebLog(name = "findDynamic", isSaved = true)
    @ApiOperation(value = "查找所有动态资讯", notes = "请求参数为传递分页参数")
    ResponseResult findDynamic(@RequestBody PageDto pageDto) {
        return ResponseResult.success(dynamicService.findDynamicByPage(pageDto));
    }

    @PostMapping("/new")
    @ControllerWebLog(name = "findDynamic", isSaved = true)
    @ApiOperation(value = "发表动态资讯", notes = "请求参数为具体动态内容")
    ResponseResult addOne(@RequestBody DynamicDto dynamicDto) {
        return ResponseResult.success(dynamicService.addOne(dynamicDto));
    }

    @PostMapping("/comment/{id}")
    @ControllerWebLog(name = "findCommentVoById", isSaved = true)
    @ApiOperation(value = "好友圈根据评论id查找多级评论", notes = "请求参数为评论id")
    ResponseResult findCommentVoById(@PathVariable int id) {
        return ResponseResult.success(dynamicService.findCommentVoById((long) id));
    }

    @ApiOperation(value = "添加评论", notes = "传递参数为内容，动态id，用户id")
    @PostMapping(value = "/comment/insert")
    public ResponseResult insertComment(@RequestBody CommentDto commentDto) {
        return commentService.insertComment(commentDto);
    }

    /**
     * 删除校友评论
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除校友评论", notes = "传递参数为comment的id")
    @PostMapping(value = "/comment/deletion/{id}")
    public ResponseResult deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }

    /**
     * 添加校友圈动态评论
     *
     * @param replyCommentDto
     * @return
     */
    @ControllerWebLog(name = "insertReplyComment", isSaved = true)
    @ApiOperation(value = "添加校友评论的评论", notes = "传递参数为内容，评论id，用户id")
    @PostMapping(value = "/replyComment/insert")
    public ResponseResult insertReplyComment(@RequestBody ReplyCommentDto replyCommentDto) {
        return replyCommentService.insertReplyComment(replyCommentDto);
    }

    /**
     * 删除校友评论
     *
     * @param id
     * @return
     */
    @ControllerWebLog(name = "deleteReplyComment", isSaved = true)
    @ApiOperation(value = "删除校友评论的评论", notes = "传递参数为reply_comment的id")
    @PostMapping(value = "/replyComment/deletion/{id}")
    public ResponseResult deleteReplyComment(@PathVariable Long id) {
        return replyCommentService.deleteReplyComment(id);
    }

    /**
     * 查询用户以收藏的动态资讯
     *
     * @param pageDto
     * @return
     */
    @ControllerWebLog(name = "getCollectionsByUserId", isSaved = true)
    @ApiOperation(value = "查询用户以收藏的动态资讯", notes = "field参数需要填写一个数字字符串，代表用户id")
    @PostMapping(value = "/Collection")
    public ResponseResult getCollectionsByUserId(@RequestBody PageDto pageDto) {
        return collectionsService.getCollectionsByUserId(pageDto);
    }

}
