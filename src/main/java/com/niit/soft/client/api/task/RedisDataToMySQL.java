package com.niit.soft.client.api.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    // 每小时
//    @Scheduled(cron = "0 0 * * * ？")
    // 每十分钟
    @Scheduled(cron = "0 */10 * * * ?")
    // 每五秒执行
//    @Scheduled(cron = "*/5 * * * * ?")
    public void redisDataToMySQL() {
        log.info("定时同步数据库 时间：{}", LocalDateTime.now());

        List<Thumb> thumbList = new ArrayList<>();
        List<Thumb> thumbListDel = new ArrayList<>();
        for (Dynamic dynamic : dynamicRepository.findAll()) {
//            log.info("" + dynamic.toString());
            Map<Object, Object> hmget = redisUtil.hmget(String.valueOf(dynamic.getPkDynamicId()));


            for (Map.Entry<Object, Object> entry : hmget.entrySet()) {
                thumbList.add(Thumb.builder().pkThumbId(Long.valueOf((String) entry.getKey()))
                        .userId(Long.valueOf((String) entry.getValue()))
                        .dynamicId(dynamic.getPkDynamicId())
                        .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                        .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                        .isDeleted(false).build());
            }
//            log.info("redis的点赞记录:{}", thumbList);
            thumbService.saveOrUpdateBatch(thumbList);

            List<Long> id = new ArrayList<>();

            for (Thumb thumb : thumbService.list(new QueryWrapper<Thumb>().eq("dynamic_id", dynamic.getPkDynamicId()))) {
                id.add(thumb.getPkThumbId());
            }
            List<Long> haveBe = id;

            for (Object o : hmget.keySet()) {
                if (id.contains(Long.parseLong((String) o))) {
                    id.remove(Long.parseLong((String) o));
                }
            }
            List<Long> shouldDelete = id;

            if (id.size() != 0) {
                for (Thumb thumb : thumbService.listByIds(id)) {
                    thumb.setIsDeleted(true);
                    thumbListDel.add(thumb);
                }
            }

            haveBe.removeAll(shouldDelete);
            dynamic.setThumbs(haveBe.size());
            dynamicRepository.saveAndFlush(dynamic);

//            log.info("redis的需要删除的点赞记录:{}", thumbListDel);
            thumbService.updateBatchById(thumbListDel);

        }

    }

}
