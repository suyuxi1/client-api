package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.InfoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Yujie_Zhao
 * @ClassName InfoTypeRepository
 * @Description 资讯分类Repository
 * @Date 2020/5/26  17:16
 * @Version 1.0
 **/
public interface InfoTypeRepository extends JpaRepository<InfoType,Long> , JpaSpecificationExecutor<InfoType> {
    /**
     * 更具id查找分类
     * @return
     */
    InfoType findByPkInfoTypeId(Long id);
}
