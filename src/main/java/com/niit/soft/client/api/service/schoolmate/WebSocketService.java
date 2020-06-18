package com.niit.soft.client.api.service.schoolmate;

import com.niit.soft.client.api.domain.model.schoolmate.Message;

import java.util.List;
import java.util.Map;

/**
 * @ClassName WebSocketService
 * @Description H5信息发送
 * @Author xiaobinggan
 * @Date 2020/6/17 9:30 上午
 * @Version 1.0
 **/
public interface WebSocketService {
    /**
     * 给用户发送信息
     *
     * @param params
     */
    void sendToUserByTemplate(Map<String, String> params);

    /**
     * 获取所有聊天记录
     *
     * @return
     */
    List<Object> getAllMessage(String key);

}