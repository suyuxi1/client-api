package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.domain.model.FleaType;
import com.niit.soft.client.api.repository.FleaTypeRepository;
import com.niit.soft.client.api.service.FleaGoodsService;
import com.niit.soft.client.api.service.FleaTypeService;
import com.niit.soft.client.api.util.TreeBuilder;
import com.niit.soft.client.api.util.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaTypeServiceImpl.java
 * @Description TODO
 * @createTime 2020年06月09日 14:06:00
 */
@Slf4j
@Service
public class FleaTypeServiceImpl implements FleaTypeService {
    @Resource
    private FleaTypeRepository fleaTypeRepository;
    @Override
    public Map<String, Object> findAllType() {
        Map<String, Object> map = new TreeMap<>();
        List<TreeNode> list = new ArrayList<>();
        //查找所有的type
        List<FleaType> types = fleaTypeRepository.findAll();
        for (FleaType fleaType : types) {
            //如果没有父节点
            if (fleaType.getParentId() == 0) {
                TreeNode treeNode = new TreeNode(fleaType.getPkFleaTypeId(), 0L, fleaType.getTypeName(), fleaType.getTypeCoverUrl(), fleaType.getTypeUrl(), new ArrayList<>());
                list.add(treeNode);
            } else {
                TreeNode treeNode = new TreeNode(fleaType.getPkFleaTypeId(), fleaType.getParentId(), fleaType.getTypeName(), fleaType.getTypeCoverUrl(), fleaType.getTypeUrl(), new ArrayList<>());
                list.add(treeNode);
            }
        }
        List<TreeNode> trees = TreeBuilder.buildTreeByLoop(list);
        map.put("types", trees);
        return map;
    }
}
