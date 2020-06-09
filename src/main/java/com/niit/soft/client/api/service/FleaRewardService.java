package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.vo.RewardVo;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaRewardService.java
 * @Description TODO
 * @createTime 2020年06月09日 14:05:00
 */
public interface FleaRewardService {
    /**
     * 查出最新的两条悬赏数据
     * @return
     */
    ResponseResult getRewardTopTwo();
}
