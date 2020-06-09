package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.service.FleaGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsServiceImpl.java
 * @Description TODO
 * @createTime 2020年06月09日 14:06:00
 */
@Slf4j
@Service
public class FleaGoodsServiceImpl implements FleaGoodsService {
    @Override
    public List<FleaGoodsService> findFileGoodsByContent(String content) {
        return null;
    }
}
