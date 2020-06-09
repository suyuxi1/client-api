package com.niit.soft.client.api.service.impl;

        import com.niit.soft.client.api.common.ResponseResult;
        import com.niit.soft.client.api.common.ResultCode;
        import com.niit.soft.client.api.domain.model.FleaReward;
        import com.niit.soft.client.api.domain.vo.RewardVo;
        import com.niit.soft.client.api.repository.FleaRewardRepository;
        import com.niit.soft.client.api.service.FleaGoodsService;
        import com.niit.soft.client.api.service.FleaRewardService;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.domain.Sort;
        import org.springframework.stereotype.Service;

        import javax.annotation.Resource;
        import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaRewardServiceImpl.java
 * @Description TODO
 * @createTime 2020年06月09日 14:06:00
 */
@Slf4j
@Service
public class FleaRewardServiceImpl implements FleaRewardService {
    @Resource
    private FleaRewardRepository rewardRepository;

    @Override
    public ResponseResult getRewardTopTwo() {
        Pageable pageable = PageRequest.of(0,2, Sort.Direction.DESC,"createTime");
        List<RewardVo> rewardVoList = rewardRepository.getTopReward(pageable);
        if (rewardVoList.size() == 0){
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(rewardVoList);
    }
}
