package com.niit.soft.client.api.service;

import com.niit.soft.client.api.domain.vo.ExaminationVo;

import java.util.List;

/**
 * @author xunmi
 * @ClassName ExaminationService
 * @Description 考务管理业务逻辑层
 * @Date 2020/6/4
 * @Version 1.0
 **/
public interface ExaminationService {

    /**
     * 通过用户账号查找该用户的所有考务信息
     *
     * @param jobNumber 学号
     * @return
     */
    List<ExaminationVo> selectAll(String jobNumber);
}
