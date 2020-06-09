package com.niit.soft.client.api.task;

import com.niit.soft.client.api.domain.model.Dynamic;
import com.niit.soft.client.api.domain.model.Thumb;
import com.niit.soft.client.api.repository.DynamicRepository;
import com.niit.soft.client.api.service.ThumbService;
import com.niit.soft.client.api.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName redisDataToMySQL
 * @Description 同步redis到mysql 点赞数
 * @Author xiaobinggan
 * @Date 2020/6/9 9:04 下午
 * @Version 1.0
 **/
@Component
@Slf4j
public class RedisDataToMySQL {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private DynamicRepository dynamicRepository;


    @Resource
    private ThumbService thumbService;

    @Scheduled(cron = "*/7 * * * * ?")
    public void redisDataToMySQL() {
        log.info("定时同步数据库 时间：{}", LocalDateTime.now());

        List<Thumb> thumbList = new ArrayList<>();
        for (Dynamic dynamic : dynamicRepository.findAll()) {
            log.info("" + dynamic.toString());
            Map<Object, Object> hmget = redisUtil.hmget(String.valueOf(dynamic.getPkDynamicId()));

            List<Long> id = new ArrayList<>();
            for (Thumb thumb : thumbService.list()) {
                id.add(thumb.getPkThumbId());
            }

            log.info("mysql的点赞记录{}", id);

            List<Thumb> thumbListDel = new ArrayList<>();

            for (Map.Entry<Object, Object> entry : hmget.entrySet()) {
                thumbList.add(Thumb.builder().pkThumbId(Long.valueOf((String) entry.getKey()))
                        .userId(Long.valueOf((String) entry.getValue()))
                        .dynamicId(dynamic.getPkDynamicId())
                        .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                        .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                        .isDeleted(false).build());
            }
            log.info("redis的点赞记录:{}", thumbList);
            thumbService.saveOrUpdateBatch(thumbList);

            for (Map.Entry<Object, Object> entry : hmget.entrySet()) {
                if (id.contains(Long.valueOf((String) entry.getKey()))) {
                    thumbList.add(Thumb.builder().pkThumbId(Long.valueOf((String) entry.getKey()))
                            .userId(Long.valueOf((String) entry.getValue()))
                            .dynamicId(dynamic.getPkDynamicId())
                            .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                            .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                            .isDeleted(true).build());
                }
            }
            thumbService.updateBatchById(thumbListDel);
        }
    }

}
