package com.niit.soft.client.api.service;

import com.niit.soft.client.api.common.ResponseResult;

/**
 * @author Yujie_Zhao
 * @ClassName InfoTypeService
 * @Description 资讯分类Service接口
 * @Date 2020/5/26  22:02
 * @Version 1.0
 **/
public interface InfoTypeService {

    /**
     * 查询所有的资讯分类
     * @return
     */
    ResponseResult getAllType();

    /**
     * 更具资讯分类id查询资讯
     * @param name
     * @return
     */
    ResponseResult getInfoByType(String name);



    /**
     * 更具资讯分类id查询资讯(测试优化方法)
     * @param id
     * @return
     */
    ResponseResult getInfoByPkInfoTypeId(Long id);
}
